// $ANTLR 3.5.2 T.g 2020-03-11 07:51:25

package pack;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "LOGICBIN", "LOGICUN", 
		"OP", "STRING", "WS", "'('", "')'", "'+'", "','", "':'", "'='", "'['", 
		"']'", "'for'", "'if'", "'in'", "'print'"
	};
	public static final int EOF=-1;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int ID=4;
	public static final int INT=5;
	public static final int LOGICBIN=6;
	public static final int LOGICUN=7;
	public static final int OP=8;
	public static final int STRING=9;
	public static final int WS=10;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public TParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public TParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return TParser.tokenNames; }
	@Override public String getGrammarFileName() { return "T.g"; }


	Functions h = new Functions();



	// $ANTLR start "prog"
	// T.g:15:1: prog : ( stmt )+ ;
	public final void prog() throws RecognitionException {
		try {
			// T.g:16:2: ( ( stmt )+ )
			// T.g:16:4: ( stmt )+
			{
			// T.g:16:4: ( stmt )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID||LA1_0==22) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// T.g:16:5: stmt
					{
					pushFollow(FOLLOW_stmt_in_prog36);
					stmt();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "prog"



	// $ANTLR start "stmt"
	// T.g:18:1: stmt : ( assignment | print );
	public final void stmt() throws RecognitionException {
		try {
			// T.g:19:2: ( assignment | print )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ID) ) {
				alt2=1;
			}
			else if ( (LA2_0==22) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// T.g:19:4: assignment
					{
					pushFollow(FOLLOW_assignment_in_stmt48);
					assignment();
					state._fsp--;

					}
					break;
				case 2 :
					// T.g:20:4: print
					{
					pushFollow(FOLLOW_print_in_stmt53);
					print();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stmt"



	// $ANTLR start "assignment"
	// T.g:23:1: assignment : ID assignment_tail[$ID.text] ;
	public final void assignment() throws RecognitionException {
		Token ID1=null;

		try {
			// T.g:24:2: ( ID assignment_tail[$ID.text] )
			// T.g:24:4: ID assignment_tail[$ID.text]
			{
			ID1=(Token)match(input,ID,FOLLOW_ID_in_assignment64); 
			pushFollow(FOLLOW_assignment_tail_in_assignment66);
			assignment_tail((ID1!=null?ID1.getText():null));
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assignment"



	// $ANTLR start "assignment_tail"
	// T.g:27:1: assignment_tail[String listID] : ( '=' list_tail[$listID] | '[' INT ']' '=' value );
	public final void assignment_tail(String listID) throws RecognitionException {
		Token INT2=null;
		Object value3 =null;

		try {
			// T.g:28:2: ( '=' list_tail[$listID] | '[' INT ']' '=' value )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==16) ) {
				alt3=1;
			}
			else if ( (LA3_0==17) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// T.g:28:4: '=' list_tail[$listID]
					{
					h.initList(listID);
					match(input,16,FOLLOW_16_in_assignment_tail82); 
					pushFollow(FOLLOW_list_tail_in_assignment_tail84);
					list_tail(listID);
					state._fsp--;

					}
					break;
				case 2 :
					// T.g:29:4: '[' INT ']' '=' value
					{
					match(input,17,FOLLOW_17_in_assignment_tail90); 
					INT2=(Token)match(input,INT,FOLLOW_INT_in_assignment_tail92); 
					match(input,18,FOLLOW_18_in_assignment_tail94); 
					match(input,16,FOLLOW_16_in_assignment_tail96); 
					pushFollow(FOLLOW_value_in_assignment_tail98);
					value3=value();
					state._fsp--;

					h.update(listID, new Integer((INT2!=null?INT2.getText():null)).intValue(), value3);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assignment_tail"



	// $ANTLR start "list_tail"
	// T.g:32:1: list_tail[String listID] : ( '[' value_list[$listID] ']' | ID term_tail[h.table.get($ID.text)] | ID '[' (start= INT )? ':' (end= INT )? ']' | '[' 'for' x= ID 'in' list= ID 'if' expr[$list.text, $x.text] ']' );
	public final void list_tail(String listID) throws RecognitionException {
		Token start=null;
		Token end=null;
		Token x=null;
		Token list=null;
		Token ID4=null;
		Token ID6=null;
		ArrayList<Object> term_tail5 =null;
		ArrayList<Boolean> expr7 =null;

		try {
			// T.g:33:2: ( '[' value_list[$listID] ']' | ID term_tail[h.table.get($ID.text)] | ID '[' (start= INT )? ':' (end= INT )? ']' | '[' 'for' x= ID 'in' list= ID 'if' expr[$list.text, $x.text] ']' )
			int alt6=4;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==17) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==19) ) {
					alt6=4;
				}
				else if ( ((LA6_1 >= ID && LA6_1 <= INT)||LA6_1==STRING||LA6_1==18) ) {
					alt6=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA6_0==ID) ) {
				int LA6_2 = input.LA(2);
				if ( (LA6_2==17) ) {
					alt6=3;
				}
				else if ( (LA6_2==EOF||LA6_2==ID||LA6_2==13||LA6_2==22) ) {
					alt6=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// T.g:33:4: '[' value_list[$listID] ']'
					{
					match(input,17,FOLLOW_17_in_list_tail113); 
					pushFollow(FOLLOW_value_list_in_list_tail115);
					value_list(listID);
					state._fsp--;

					match(input,18,FOLLOW_18_in_list_tail118); 
					}
					break;
				case 2 :
					// T.g:34:4: ID term_tail[h.table.get($ID.text)]
					{
					ID4=(Token)match(input,ID,FOLLOW_ID_in_list_tail123); 
					pushFollow(FOLLOW_term_tail_in_list_tail125);
					term_tail5=term_tail(h.table.get((ID4!=null?ID4.getText():null)));
					state._fsp--;

					h.table.put(listID, term_tail5);
					}
					break;
				case 3 :
					// T.g:35:4: ID '[' (start= INT )? ':' (end= INT )? ']'
					{
					ID6=(Token)match(input,ID,FOLLOW_ID_in_list_tail133); 
					match(input,17,FOLLOW_17_in_list_tail135); 
					// T.g:35:16: (start= INT )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==INT) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// T.g:35:16: start= INT
							{
							start=(Token)match(input,INT,FOLLOW_INT_in_list_tail139); 
							}
							break;

					}

					match(input,15,FOLLOW_15_in_list_tail142); 
					// T.g:35:29: (end= INT )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==INT) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// T.g:35:29: end= INT
							{
							end=(Token)match(input,INT,FOLLOW_INT_in_list_tail146); 
							}
							break;

					}

					match(input,18,FOLLOW_18_in_list_tail149); 
					h.assignSlice(listID, (ID6!=null?ID6.getText():null), (start!=null?start.getText():null), (end!=null?end.getText():null));
					}
					break;
				case 4 :
					// T.g:36:4: '[' 'for' x= ID 'in' list= ID 'if' expr[$list.text, $x.text] ']'
					{
					match(input,17,FOLLOW_17_in_list_tail156); 
					match(input,19,FOLLOW_19_in_list_tail158); 
					x=(Token)match(input,ID,FOLLOW_ID_in_list_tail162); 
					match(input,21,FOLLOW_21_in_list_tail164); 
					list=(Token)match(input,ID,FOLLOW_ID_in_list_tail168); 
					match(input,20,FOLLOW_20_in_list_tail170); 
					pushFollow(FOLLOW_expr_in_list_tail172);
					expr7=expr((list!=null?list.getText():null), (x!=null?x.getText():null));
					state._fsp--;

					match(input,18,FOLLOW_18_in_list_tail175); 
					h.listComprehension(listID, (list!=null?list.getText():null), expr7);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "list_tail"



	// $ANTLR start "term_tail"
	// T.g:40:1: term_tail[ArrayList<Object> prev] returns [ArrayList<Object> result] : ( '+' ID t2= term_tail[h.concatenate($prev, h.table.get($ID.text))] |);
	public final ArrayList<Object> term_tail(ArrayList<Object> prev) throws RecognitionException {
		ArrayList<Object> result = null;


		Token ID8=null;
		ArrayList<Object> t2 =null;

		try {
			// T.g:41:2: ( '+' ID t2= term_tail[h.concatenate($prev, h.table.get($ID.text))] |)
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==13) ) {
				alt7=1;
			}
			else if ( (LA7_0==EOF||LA7_0==ID||LA7_0==22) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// T.g:41:4: '+' ID t2= term_tail[h.concatenate($prev, h.table.get($ID.text))]
					{
					match(input,13,FOLLOW_13_in_term_tail195); 
					ID8=(Token)match(input,ID,FOLLOW_ID_in_term_tail197); 
					pushFollow(FOLLOW_term_tail_in_term_tail201);
					t2=term_tail(h.concatenate(prev, h.table.get((ID8!=null?ID8.getText():null))));
					state._fsp--;

					result = t2;
					}
					break;
				case 2 :
					// T.g:42:4: 
					{
					result = prev;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "term_tail"



	// $ANTLR start "value_list"
	// T.g:45:1: value_list[String listID] : (v1= value ( ',' v2= value )* |);
	public final void value_list(String listID) throws RecognitionException {
		Object v1 =null;
		Object v2 =null;

		try {
			// T.g:46:2: (v1= value ( ',' v2= value )* |)
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( ((LA9_0 >= ID && LA9_0 <= INT)||LA9_0==STRING) ) {
				alt9=1;
			}
			else if ( (LA9_0==18) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// T.g:46:4: v1= value ( ',' v2= value )*
					{
					pushFollow(FOLLOW_value_in_value_list224);
					v1=value();
					state._fsp--;

					h.addToList(listID, v1);
					// T.g:47:2: ( ',' v2= value )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( (LA8_0==14) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// T.g:47:3: ',' v2= value
							{
							match(input,14,FOLLOW_14_in_value_list232); 
							pushFollow(FOLLOW_value_in_value_list236);
							v2=value();
							state._fsp--;

							h.addToList(listID, v2);
							}
							break;

						default :
							break loop8;
						}
					}

					}
					break;
				case 2 :
					// T.g:49:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "value_list"



	// $ANTLR start "value"
	// T.g:51:1: value returns [Object val] : ( INT | STRING | ID );
	public final Object value() throws RecognitionException {
		Object val = null;


		Token INT9=null;
		Token STRING10=null;
		Token ID11=null;

		try {
			// T.g:52:2: ( INT | STRING | ID )
			int alt10=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt10=1;
				}
				break;
			case STRING:
				{
				alt10=2;
				}
				break;
			case ID:
				{
				alt10=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// T.g:52:4: INT
					{
					INT9=(Token)match(input,INT,FOLLOW_INT_in_value258); 
					val = new Integer((INT9!=null?INT9.getText():null));
					}
					break;
				case 2 :
					// T.g:53:4: STRING
					{
					STRING10=(Token)match(input,STRING,FOLLOW_STRING_in_value267); 
					val = new String((STRING10!=null?STRING10.getText():null));
					}
					break;
				case 3 :
					// T.g:54:4: ID
					{
					ID11=(Token)match(input,ID,FOLLOW_ID_in_value274); 
					val = new String((ID11!=null?ID11.getText():null));
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return val;
	}
	// $ANTLR end "value"



	// $ANTLR start "expr"
	// T.g:57:1: expr[String list, String x] returns [ArrayList<Boolean> result] : ( '(' e1= expr[$list, $x] LOGICBIN e2= expr[$list, $x] ')' | LOGICUN e3= expr[$list, $x] | '(' op1= operand OP op2= operand ')' );
	public final ArrayList<Boolean> expr(String list, String x) throws RecognitionException {
		ArrayList<Boolean> result = null;


		Token LOGICBIN12=null;
		Token LOGICUN13=null;
		Token OP14=null;
		ArrayList<Boolean> e1 =null;
		ArrayList<Boolean> e2 =null;
		ArrayList<Boolean> e3 =null;
		Object op1 =null;
		Object op2 =null;

		try {
			// T.g:58:2: ( '(' e1= expr[$list, $x] LOGICBIN e2= expr[$list, $x] ')' | LOGICUN e3= expr[$list, $x] | '(' op1= operand OP op2= operand ')' )
			int alt11=3;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==11) ) {
				int LA11_1 = input.LA(2);
				if ( (LA11_1==LOGICUN||LA11_1==11) ) {
					alt11=1;
				}
				else if ( ((LA11_1 >= ID && LA11_1 <= INT)) ) {
					alt11=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA11_0==LOGICUN) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// T.g:58:4: '(' e1= expr[$list, $x] LOGICBIN e2= expr[$list, $x] ')'
					{
					match(input,11,FOLLOW_11_in_expr293); 
					pushFollow(FOLLOW_expr_in_expr297);
					e1=expr(list, x);
					state._fsp--;

					LOGICBIN12=(Token)match(input,LOGICBIN,FOLLOW_LOGICBIN_in_expr300); 
					pushFollow(FOLLOW_expr_in_expr304);
					e2=expr(list, x);
					state._fsp--;

					match(input,12,FOLLOW_12_in_expr307); 
					result = h.logicBinaryEvaluate(e1, e2, (LOGICBIN12!=null?LOGICBIN12.getText():null));
					}
					break;
				case 2 :
					// T.g:60:5: LOGICUN e3= expr[$list, $x]
					{
					LOGICUN13=(Token)match(input,LOGICUN,FOLLOW_LOGICUN_in_expr317); 
					pushFollow(FOLLOW_expr_in_expr321);
					e3=expr(list, x);
					state._fsp--;

					result = h.logicUnaryEvaluate(e3, (LOGICUN13!=null?LOGICUN13.getText():null));
					}
					break;
				case 3 :
					// T.g:62:4: '(' op1= operand OP op2= operand ')'
					{
					match(input,11,FOLLOW_11_in_expr330); 
					pushFollow(FOLLOW_operand_in_expr334);
					op1=operand();
					state._fsp--;

					OP14=(Token)match(input,OP,FOLLOW_OP_in_expr336); 
					pushFollow(FOLLOW_operand_in_expr340);
					op2=operand();
					state._fsp--;

					match(input,12,FOLLOW_12_in_expr342); 
					result = h.comparison(list, op1.toString(), op2.toString(), (OP14!=null?OP14.getText():null), x);
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "expr"



	// $ANTLR start "operand"
	// T.g:66:1: operand returns [Object val] : ( ID | INT );
	public final Object operand() throws RecognitionException {
		Object val = null;


		Token ID15=null;
		Token INT16=null;

		try {
			// T.g:67:2: ( ID | INT )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==ID) ) {
				alt12=1;
			}
			else if ( (LA12_0==INT) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// T.g:67:4: ID
					{
					ID15=(Token)match(input,ID,FOLLOW_ID_in_operand361); 
					val = new String((ID15!=null?ID15.getText():null));
					}
					break;
				case 2 :
					// T.g:68:4: INT
					{
					INT16=(Token)match(input,INT,FOLLOW_INT_in_operand369); 
					val = new Integer((INT16!=null?INT16.getText():null));
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return val;
	}
	// $ANTLR end "operand"



	// $ANTLR start "print"
	// T.g:71:1: print : 'print' '(' ID ')' ;
	public final void print() throws RecognitionException {
		Token ID17=null;

		try {
			// T.g:72:2: ( 'print' '(' ID ')' )
			// T.g:72:4: 'print' '(' ID ')'
			{
			match(input,22,FOLLOW_22_in_print384); 
			match(input,11,FOLLOW_11_in_print386); 
			ID17=(Token)match(input,ID,FOLLOW_ID_in_print388); 
			match(input,12,FOLLOW_12_in_print390); 
			 h.printList((ID17!=null?ID17.getText():null)); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "print"

	// Delegated rules



	public static final BitSet FOLLOW_stmt_in_prog36 = new BitSet(new long[]{0x0000000000400012L});
	public static final BitSet FOLLOW_assignment_in_stmt48 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_in_stmt53 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assignment64 = new BitSet(new long[]{0x0000000000030000L});
	public static final BitSet FOLLOW_assignment_tail_in_assignment66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_assignment_tail82 = new BitSet(new long[]{0x0000000000020010L});
	public static final BitSet FOLLOW_list_tail_in_assignment_tail84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_assignment_tail90 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_INT_in_assignment_tail92 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_assignment_tail94 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_assignment_tail96 = new BitSet(new long[]{0x0000000000000230L});
	public static final BitSet FOLLOW_value_in_assignment_tail98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_list_tail113 = new BitSet(new long[]{0x0000000000040230L});
	public static final BitSet FOLLOW_value_list_in_list_tail115 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_list_tail118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_list_tail123 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_term_tail_in_list_tail125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_list_tail133 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_list_tail135 = new BitSet(new long[]{0x0000000000008020L});
	public static final BitSet FOLLOW_INT_in_list_tail139 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_list_tail142 = new BitSet(new long[]{0x0000000000040020L});
	public static final BitSet FOLLOW_INT_in_list_tail146 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_list_tail149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_list_tail156 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_list_tail158 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_list_tail162 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_list_tail164 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_list_tail168 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_list_tail170 = new BitSet(new long[]{0x0000000000000880L});
	public static final BitSet FOLLOW_expr_in_list_tail172 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_list_tail175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_term_tail195 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_term_tail197 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_term_tail_in_term_tail201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_value_list224 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_value_list232 = new BitSet(new long[]{0x0000000000000230L});
	public static final BitSet FOLLOW_value_in_value_list236 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_INT_in_value258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_value267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_expr293 = new BitSet(new long[]{0x0000000000000880L});
	public static final BitSet FOLLOW_expr_in_expr297 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_LOGICBIN_in_expr300 = new BitSet(new long[]{0x0000000000000880L});
	public static final BitSet FOLLOW_expr_in_expr304 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_expr307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOGICUN_in_expr317 = new BitSet(new long[]{0x0000000000000880L});
	public static final BitSet FOLLOW_expr_in_expr321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_expr330 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_operand_in_expr334 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_OP_in_expr336 = new BitSet(new long[]{0x0000000000000030L});
	public static final BitSet FOLLOW_operand_in_expr340 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_expr342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_operand361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_operand369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_print384 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_print386 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_print388 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_print390 = new BitSet(new long[]{0x0000000000000002L});
}

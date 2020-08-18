//open project with IntelliJ IDEA

grammar T;

@parser::header {
package pack;
}

@lexer::header {
package pack;
}

@members {
Functions h = new Functions();
}

prog
	: (stmt)+
	;
stmt
	: assignment
	| print
	;

assignment
	: ID assignment_tail[$ID.text]
	;

assignment_tail [String listID]
	: {h.initList($listID);} '=' list_tail[$listID]
	| '[' INT ']' '=' value {h.update($listID, new Integer($INT.text).intValue(), $value.val);}
	;

list_tail [String listID]
	: '[' value_list[$listID] ']'
	| ID term_tail[h.table.get($ID.text)] {h.table.put($listID, $term_tail.result);}
	| ID '[' start=INT? ':' end=INT? ']' {h.assignSlice($listID, $ID.text, $start.text, $end.text);}
	| '[' 'for' x=ID 'in' list=ID 'if' expr[$list.text, $x.text] ']'
	{h.listComprehension($listID, $list.text, $expr.result);}
	;

term_tail [ArrayList<Object> prev] returns [ArrayList<Object> result]
	: '+' ID t2=term_tail[h.concatenate($prev, h.table.get($ID.text))] {$result = $t2.result;}
	| {$result = $prev;}
	;

value_list [String listID]
	: v1=value {h.addToList($listID, $v1.val);}
	(',' v2=value {h.addToList($listID, $v2.val);})*
	|
	;

value returns [Object val]
	: INT 		{$val = new Integer($INT.text);}
	| STRING	{$val = new String($STRING.text);}
	| ID		{$val = new String($ID.text);}
	;

expr[String list, String x] returns [ArrayList<Boolean> result]
	: '(' e1=expr[$list, $x] LOGICBIN e2=expr[$list, $x] ')'
	{$result = h.logicBinaryEvaluate($e1.result, $e2.result, $LOGICBIN.text);}
	|  LOGICUN e3=expr[$list, $x]
	{$result = h.logicUnaryEvaluate($e3.result, $LOGICUN.text);}
	| '(' op1=operand OP op2=operand ')'
	{$result = h.comparison($list, $op1.val.toString(), $op2.val.toString(), $OP.text, $x);}
	;

operand returns [Object val]
	: ID		{$val = new String($ID.text);}
	| INT 		{$val = new Integer($INT.text);}
	;

print
	: 'print' '(' ID ')'	{ h.printList($ID.text); }
	;


//SCANNER

LOGICBIN
    : ('and' | 'or')
    ;

LOGICUN
    : 'not'
    ;

ID
    : ('_'|'a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT
    : ('-')?('0'..'9')+
    ;

STRING
    : '\'' ~('\r' | '\n' | '\'')* '\''
    ;

OP
    : ('==' | '!=' | '<'| '<=' | '>' | '>=')
    ;

WS
    : (' '|'\t'|'\n'|'\r')* {skip();}
    ;

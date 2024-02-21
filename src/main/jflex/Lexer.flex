package com.srbn.Lexer;

import com.srbn.Parser.ParserSym;
import java_cup.runtime.*;
import java.io.*;

%%

//JFlex Config
%class Lexer
%unicode
%line
%column
%cup
%public

//REGEXs

ENDLINE     = \r|\n|\r\n
WHITESPCS   = [ \t\f]+ | {ENDLINE}

LETTER      = [a-zA-Z]
NUMBER      = [0-9]+
OPERATORS   = \* | \/ | \- | \+ | \^ | \%
//reserved Words


%{
    StringBuffer sb = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    private void error(String message) {
        System.out.println("Error at row:"+(yyline+1)+", col: "+(yycolumn+1)+" : "+message);
    }
%}

%eofval{
	return new Symbol(ParserSym.EOF);
%eofval}

%%

{LETTER}                          {return symbol(ParserSym.LETTER, yytext());}
{NUMBER}                          {return symbol(ParserSym.NUMBER, yytext());}

{WHITESPCS}+                      {}
//erores
.                                 {return error("Unreconogized character: <" +yytext()+">");}
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
%caseless
%ignorecase
%cup
%public

//REGEXs

ENDLINE     = \r|\n|\r\n
WHITESPCS   = [ \t\f]+ | {ENDLINE}

LETTER      = [a-zA-Z]
NUMBER      = [0-9]+
OPERATORS   = \* | \/ | \- | \+ | \^ | \%
SEMICOLON   = ";"
//reserved Words
SELECCIONAR = "SELECCIONAR"
FILTRAR     = "FILTRAR"
INSERTAR    = "INSERTAR"
ACTUALIZAR  = "ACTUALIZAR"
ASIGNAR     = "ASIGNAR"
ELIMINAR    = "ELIMINAR"
EN          = "EN"
FILTRAR     = "FILTRAR"
VALORES     = "VALORES"
//relational ops
EQUAL       = "="
MINORQ      = "<"
MINOR_EQ    = "<="
MAYORQ      = ">"
MAYOR_EQ    = ">="
INEQUAL     = "<>"
//logical ops
AND         = "AND"
OR          = "OR"

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
{LETTER}                          {return symbol(ParserSym.LETTER, yytext());}
{NUMBER}                          {return symbol(ParserSym.NUMBER, yytext());}
{OPERATORS}                       {return symbol(ParserSym.OPERATOR, yytext());}
{SEMICOLON}                       {return symbol(ParserSym.SEMICOLON, yytext());}
{SELECCIONAR}                     {return symbol(ParserSym.SELECCIONAR, yytext());}
{FILTRAR}                         {return symbol(ParserSym.FILTRAR, yytext());}
{INSERTAR}                        {return symbol(ParserSym.INSERTAR, yytext());}
{ACTUALIZAR}                      {return symbol(ParserSym.ACTUALIZAR, yytext());}
{ASIGNAR}                         {return symbol(ParserSym.ASIGNAR, yytext());}
{ELIMINAR}                        {return symbol(ParserSym.ELIMINAR, yytext());}
{EN}                              {return symbol(ParserSym.EN, yytext());}
{FILTRAR}                         {return symbol(ParserSym.FILTRAR, yytext());}
{VALORES}                         {return symbol(ParserSym.VALORES, yytext());}
{EQUAL}                           {return symbol(ParserSym.EQUAL, yytext());}
{MINORQ}                          {return symbol(ParserSym.MINORQ, yytext());}
{MINOR_EQ}                        {return symbol(ParserSym.MINOR_EQ, yytext());}
{MAYORQ}                          {return symbol(ParserSym.MAYORQ, yytext());}
{MAYOR_EQ}                        {return symbol(ParserSym.MAYOR_EQ, yytext());}
{INEQUAL}                         {return symbol(ParserSym.INEQUAL, yytext());}
{AND}                             {return symbol(ParserSym.AND, yytext());}
{OR}                              {return symbol(ParserSym.OR, yytext());}
{WHITESPCS}+                      {}
//erores
.                                 {return error("Unreconogized character: <" +yytext()+">");}

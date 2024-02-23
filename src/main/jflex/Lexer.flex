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
OPERATORS   = \/ | \- | \+ | \^ | \%
SEMICOLON   = ";"
OPNPARENT   = "("
CLSPARENT   = ")"
DBLEQUOTES  = "\""
DOT         = "."
COMMA       = ","
ASTERISK   = "*"
//reserved Words
SELECCIONAR = "SELECCIONAR"
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
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

    private void error(String message) {
        System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
      }
%}

%eofval{
	return new Symbol(ParserSym.EOF);
%eofval}

%%

{SELECCIONAR}                     {return symbol(ParserSym.SELECCIONAR, yytext());}
{FILTRAR}                         {return symbol(ParserSym.FILTRAR, yytext());}
{INSERTAR}                        {return symbol(ParserSym.INSERTAR, yytext());}
{ACTUALIZAR}                      {return symbol(ParserSym.ACTUALIZAR, yytext());}
{ASIGNAR}                         {return symbol(ParserSym.ASIGNAR, yytext());}
{ELIMINAR}                        {return symbol(ParserSym.ELIMINAR, yytext());}
{EN}                              {return symbol(ParserSym.EN, yytext());}
{VALORES}                         {return symbol(ParserSym.VALORES, yytext());}
{AND}                             {return symbol(ParserSym.AND, yytext());}
{OR}                              {return symbol(ParserSym.OR, yytext());}
{ASTERISK}                       {return symbol(ParserSym.ASTERISK, yytext());}
{NUMBER}                          {return symbol(ParserSym.NUMBER, yytext());}
({LETTER}|{NUMBER})+      {return symbol(ParserSym.WORD, yytext());}
{SEMICOLON}                       {return symbol(ParserSym.SEMICOLON, yytext());}
{OPNPARENT}                       {return symbol(ParserSym.OPNPARENT, yytext());}
{CLSPARENT}                       {return symbol(ParserSym.CLSPARENT, yytext());}
{DBLEQUOTES}                      {return symbol(ParserSym.DBLEQUOTES, yytext());}
{DOT}                             {return symbol(ParserSym.DOT, yytext());}
{COMMA}                           {return symbol(ParserSym.COMMA, yytext());}
{EQUAL}                           {return symbol(ParserSym.EQUAL, yytext());}
{MINORQ}                          {return symbol(ParserSym.MINORQ, yytext());}
{MINOR_EQ}                        {return symbol(ParserSym.MINOR_EQ, yytext());}
{MAYORQ}                          {return symbol(ParserSym.MAYORQ, yytext());}
{MAYOR_EQ}                        {return symbol(ParserSym.MAYOR_EQ, yytext());}
{INEQUAL}                         {return symbol(ParserSym.INEQUAL, yytext());}
{WHITESPCS}+                      {}
//erores
.                                 {System.err.println("warning: Unrecognized character '" + yytext()+"' -- ignored" + " at : "+ (yyline+1) + " " + (yycolumn+1) + " " + yychar);}

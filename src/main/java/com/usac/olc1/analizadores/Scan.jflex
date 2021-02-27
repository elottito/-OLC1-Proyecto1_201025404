/* --------------------------------------
   C O D I G O    D E    U S U A R I O
-------------------------------------- */
package com.usac.olc1.analizadores;
import java_cup.runtime.Symbol;
%%

/* ---------------------------------------------------
   O P C I O N E S    Y    D E C L A R A C I O N E S
---------------------------------------------------- */
%cupsym TablaSimbolos
%class AnalizadorLexico
%public
%cup
%line
%column
%char
%unicode

// Estados	
%state CADENA 

// Metodo de Salida - Codigo en Java
%{
	StringBuffer string = new StringBuffer();
	String strCadena = ""; //Se utiliza para obtener un String sin las comillas
	
	public void findErrorLexico(String lexema, int fila, int columna){
		System.out.println("Error Lexico: -----> " + lexema + "\t[" + fila + "," + columna + "]");
	}
%}

// E X P R E S I O N E S    R E G U L A R E S 
// Palabras Reservadas
CONJ  = "CONJ"

// Simbolos
COMA		= ","
COMILLA		= "\""
DOSPUNTOS	= ":"
FLECHA		= "->"
LLAVE_A		= "{"
LLAVE_C		= "}"
PUNTOCOMA	= ";"
PORCENTAJE	= "%"
VIRGULILLA	= "~"

//Operadores
PUNTO 		= "."
BARRA 		= "|"
POR			= "*"
MAS			= "+"
INTER		= "?"

//Simbolos Especiales
SALTO_LINEA = "\\n"     // Expresion aceptada: \n
SIM_COM_DOB = "\\\""    // Expresion aceptada: \"
SIM_COM_SIM = "\\'"     // Expresion aceptada: \'

// Expresiones Regulares
NUMERO		= [0-9]
LETRA		= [A-Za-zÑñ]
ID			= {LETRA}({LETRA}|{NUMERO}|_)*

//Simbolos Ascci del 33-125
SIMBOLO		= [!-}]

// Espacios en Blanco
CUALQUIERA	= [^\r\n] // Cualquier caracter menos: retorno de carro y salto de linea
FIN_LINEA	= \r|\n|\r\n
BLANCOS		= {FIN_LINEA} | [ \t\f]

// Comentarios
COMENTARIO_SIMPLE		= "//" {CUALQUIERA}* {FIN_LINEA}?
COMENTARIO_MULTILINEA	= "<!" [^!] ~"!>" | "<!" "!"+ ">"
COMENTARIOS 			= {COMENTARIO_SIMPLE} | {COMENTARIO_MULTILINEA}
%%

/* ------------------------------------------
   A R C H I V O S    D E    E N T R A D A
------------------------------------------ */
<YYINITIAL>{
	// Palabras Reservadas
	{CONJ}				{	return new Symbol(TablaSimbolos.CONJ,			yycolumn, yyline + 1, yytext()); }

	// Simbolos
	{COMA}				{	return new Symbol(TablaSimbolos.COMA,			yycolumn, yyline + 1, yytext()); }
	{DOSPUNTOS}			{	return new Symbol(TablaSimbolos.DOSPUNTOS,		yycolumn, yyline + 1, yytext()); }
	{FLECHA}			{	return new Symbol(TablaSimbolos.FLECHA,			yycolumn, yyline + 1, yytext()); }
	{LLAVE_A}			{	return new Symbol(TablaSimbolos.LLAVE_A,		yycolumn, yyline + 1, yytext()); }
	{LLAVE_C}			{	return new Symbol(TablaSimbolos.LLAVE_C,		yycolumn, yyline + 1, yytext()); }
	{PUNTOCOMA}			{	return new Symbol(TablaSimbolos.PUNTOCOMA,		yycolumn, yyline + 1, yytext()); }
	{PORCENTAJE}		{	return new Symbol(TablaSimbolos.PORCENTAJE,		yycolumn, yyline + 1, yytext()); }
	{VIRGULILLA}		{	return new Symbol(TablaSimbolos.VIRGULILLA,		yycolumn, yyline + 1, yytext()); }

	//Operadores
	{PUNTO}				{	return new Symbol(TablaSimbolos.PUNTO,			yycolumn, yyline + 1, yytext()); }
	{BARRA}				{	return new Symbol(TablaSimbolos.BARRA,			yycolumn, yyline + 1, yytext()); }
	{POR}				{	return new Symbol(TablaSimbolos.POR,			yycolumn, yyline + 1, yytext()); }
	{MAS}				{	return new Symbol(TablaSimbolos.MAS,			yycolumn, yyline + 1, yytext()); }
	{INTER}				{	return new Symbol(TablaSimbolos.INTER,			yycolumn, yyline + 1, yytext()); }

	//Simbolos Especiales
	{SALTO_LINEA}		{	return new Symbol(TablaSimbolos.SALTO_LINEA,	yycolumn, yyline + 1, yytext()); }
	{SIM_COM_DOB}		{	return new Symbol(TablaSimbolos.SIM_COM_DOB,	yycolumn, yyline + 1, yytext()); }
	{SIM_COM_SIM}		{	return new Symbol(TablaSimbolos.SIM_COM_SIM,	yycolumn, yyline + 1, yytext()); }

	// Cadena
	{COMILLA}			{	yybegin(CADENA);	}

	// Expresiones Regulares
	{NUMERO}			{	return new Symbol(TablaSimbolos.NUMERO, 		yycolumn, yyline + 1, yytext()); }
	{ID}				{	return new Symbol(TablaSimbolos.ID, 			yycolumn, yyline + 1, yytext()); }
	{SIMBOLO}			{
							System.out.println("Simbolo: " + yytext());
							return new Symbol(TablaSimbolos.SIMBOLO, 		yycolumn, yyline + 1, yytext()); 
						}

	// Espacios en Blanco
	{BLANCOS}			{	/* Se Ignoran los Espacios en Blanco*/	}
	{COMENTARIOS}		{	/* Se Ignoran los Comentarios*/	}

	// Errores Lexicos
	.					{	findErrorLexico(yytext(), yyline, yycolumn); }
}

// ESTADO: Cadena
<CADENA>{
	{COMILLA} 
	{
		String strTemporal = strCadena;
		strCadena = ""; // Se limpia para que una siguiente cadena que pueda venir
		yybegin(YYINITIAL);
		System.out.println("Cadena: " + strTemporal);
		return new Symbol(TablaSimbolos.CADENA, yycolumn, yyline + 1, strTemporal);
	}
	[^"\""]				{   strCadena += yytext();  }
}
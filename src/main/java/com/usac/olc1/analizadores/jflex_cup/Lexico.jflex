/* --------------------------------------
   C O D I G O    D E    U S U A R I O
-------------------------------------- */
package com.usac.olc1.analizadores;
import java_cup.runtime.Symbol;

import com.usac.olc1.nodos.ErrorNode;
import com.usac.olc1.st.ExceptionST;
import com.usac.olc1.st.Tree;
import com.usac.olc1.st.TypeError;

%%

/* ---------------------------------------------------
   O P C I O N E S    Y    D E C L A R A C I O N E S
---------------------------------------------------- */
%cupsym TSymbol
%class Lexico
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
	
	/**
	* Metodo que almacena los errores lexicos que se encuentren
	* @param lexema Lexema.
	* @param line Fila.
	* @param column Columna.
	*/
	public Tree findErrorLexico(String lexema, int line, int column){		
		String tipoError = TypeError.typesError.LEXICO.toString();
		String descripcion = "El caracter <b>" + lexema + "</b> no pertenece al lenguaje";
		column = column + 1;
		line = line + 1;
		ExceptionST error = new ExceptionST(tipoError, descripcion, line, column);
		ErrorNode en = new ErrorNode(error , line, column );
		
		Tree t = new Tree(null);
		t.console.add("Error Lexico: -----> " + lexema + "\t[" + line + "," + column + "]");
		t.exceptions.add(error);
		return t;
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
PERCENT_D	= "%%"
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
	{CONJ} 				{	return new Symbol(TSymbol.conj, 		yycolumn, yyline, yytext()); }

	// Simbolos
	{COMA}				{	return new Symbol(TSymbol.coma,			yycolumn, yyline, yytext()); }
	{DOSPUNTOS}			{	return new Symbol(TSymbol.dospuntos,	yycolumn, yyline, yytext()); }
	{FLECHA}			{	return new Symbol(TSymbol.flecha,		yycolumn, yyline, yytext()); }
	{LLAVE_A}			{	return new Symbol(TSymbol.llave_a,		yycolumn, yyline, yytext()); }
	{LLAVE_C}			{	return new Symbol(TSymbol.llave_c,		yycolumn, yyline, yytext()); }
	{PUNTOCOMA}			{	return new Symbol(TSymbol.puntocoma,	yycolumn, yyline, yytext()); }
	{PERCENT_D}			{	return new Symbol(TSymbol.percent_d,	yycolumn, yyline, yytext()); }
	{VIRGULILLA}		{	return new Symbol(TSymbol.virgulilla,	yycolumn, yyline, yytext()); }

	//Operadores
	{PUNTO}				{	return new Symbol(TSymbol.punto,		yycolumn, yyline, yytext()); }
	{BARRA}				{	return new Symbol(TSymbol.barra,		yycolumn, yyline, yytext()); }
	{POR}				{	return new Symbol(TSymbol.por,			yycolumn, yyline, yytext()); }
	{MAS}				{	return new Symbol(TSymbol.mas,			yycolumn, yyline, yytext()); }
	{INTER}				{	return new Symbol(TSymbol.inter,		yycolumn, yyline, yytext()); }

	//Simbolos Especiales
	{SALTO_LINEA}		{	return new Symbol(TSymbol.salto_linea,	yycolumn, yyline, yytext()); }
	{SIM_COM_DOB}		{	return new Symbol(TSymbol.sim_com_dob,	yycolumn, yyline, yytext()); }
	{SIM_COM_SIM}		{	return new Symbol(TSymbol.sim_com_sim,	yycolumn, yyline, yytext()); }

	// Cadena
	{COMILLA}			{	yybegin(CADENA);	}
	
	// Expresiones Regulares
	{LETRA}				{	return new Symbol(TSymbol.letra, 		yycolumn, yyline, yytext()); }
	{NUMERO}			{	return new Symbol(TSymbol.numero, 		yycolumn, yyline, yytext()); }
	{ID}				{	return new Symbol(TSymbol.id, 			yycolumn, yyline, yytext()); }
	{SIMBOLO}			{	return new Symbol(TSymbol.simbolo, 		yycolumn, yyline, yytext()); }

	// Espacios en Blanco
	{BLANCOS}			{	/* Se Ignoran los Espacios en Blanco*/		}
	{COMENTARIOS}		{	/* Se Ignoran los Comentarios*/				}

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
		return new Symbol(TSymbol.cadena, yycolumn, yyline, strTemporal);
	}
	[^"\""]				{   strCadena += yytext();  }
}
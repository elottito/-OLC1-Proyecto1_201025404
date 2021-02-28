/* --------------------------------------
   C O D I G O    D E    U S U A R I O
-------------------------------------- */
package com.usac.olc1.analizadores;
import java_cup.runtime.Symbol;

import com.usac.olc1.App;
import com.usac.olc1.nodos.Errores;
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
	
	/**
	* Metodo que muestra indiviualmente los tokens encontrados
	* @param lexema Lexema
	* @param fila Fila
	* @param columna Columna
	* @param tipo Tipo de Token
	*/
	public void finToken(String lexema, int fila, int columna, String tipo){
		fila = fila + 1;
		columna = columna + 1;
		System.out.println("[" + fila + "," + columna+ "]\tToken: " + tipo + "\tLexema: " + lexema);
	}

	/**
	* Metodo que almacena los errores lexicos que se encuentren
	* @param lexema Lexema.
	* @param fila Fila.
	* @param columna Columna.
	*/
	public void findErrorLexico(String lexema, int fila, int columna){
		fila = fila + 1;
		columna = columna + 1;
		String descripcion = "Error Léxico Recuperado<br>El caracter <b>" + lexema + "</b> no pertenece al lenguaje";
		System.out.println("Error Lexico: -----> " + lexema + "\t[" + fila + "," + columna + "]");
		Errores errorLexico = new Errores(fila, columna, lexema, descripcion);
		App.listaErrores.add(errorLexico);
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
	{CONJ} 				{	return new Symbol(TablaSimbolos.conj, 			yycolumn, yyline, yytext()); }

	// Simbolos
	{COMA}				{	return new Symbol(TablaSimbolos.coma,			yycolumn, yyline, yytext()); }
	{DOSPUNTOS}			{	return new Symbol(TablaSimbolos.dospuntos,		yycolumn, yyline, yytext()); }
	{FLECHA}			{	return new Symbol(TablaSimbolos.flecha,			yycolumn, yyline, yytext()); }
	{LLAVE_A}			{	return new Symbol(TablaSimbolos.llave_a,		yycolumn, yyline, yytext()); }
	{LLAVE_C}			{	return new Symbol(TablaSimbolos.llave_c,		yycolumn, yyline, yytext()); }
	{PUNTOCOMA}			{	return new Symbol(TablaSimbolos.puntocoma,		yycolumn, yyline, yytext()); }
	{PERCENT_D}			{	return new Symbol(TablaSimbolos.percent_d,		yycolumn, yyline, yytext()); }
	{VIRGULILLA}		{	return new Symbol(TablaSimbolos.virgulilla,		yycolumn, yyline, yytext()); }

	//Operadores
	{PUNTO}				{	return new Symbol(TablaSimbolos.punto,			yycolumn, yyline, yytext()); }
	{BARRA}				{	return new Symbol(TablaSimbolos.barra,			yycolumn, yyline, yytext()); }
	{POR}				{	return new Symbol(TablaSimbolos.por,			yycolumn, yyline, yytext()); }
	{MAS}				{	return new Symbol(TablaSimbolos.mas,			yycolumn, yyline, yytext()); }
	{INTER}				{	return new Symbol(TablaSimbolos.inter,			yycolumn, yyline, yytext()); }

	//Simbolos Especiales
	{SALTO_LINEA}		{	return new Symbol(TablaSimbolos.salto_linea,	yycolumn, yyline, yytext()); }
	{SIM_COM_DOB}		{	return new Symbol(TablaSimbolos.sim_com_dob,	yycolumn, yyline, yytext()); }
	{SIM_COM_SIM}		{	return new Symbol(TablaSimbolos.sim_com_sim,	yycolumn, yyline, yytext()); }

	// Cadena
	{COMILLA}			{	yybegin(CADENA);	}
	
	// Expresiones Regulares
	{LETRA}				{	return new Symbol(TablaSimbolos.letra, 			yycolumn, yyline, yytext()); }
	{NUMERO}			{	return new Symbol(TablaSimbolos.numero, 		yycolumn, yyline, yytext()); }
	{ID}				{	return new Symbol(TablaSimbolos.id, 			yycolumn, yyline, yytext()); }
	{SIMBOLO}			{	return new Symbol(TablaSimbolos.simbolo, 		yycolumn, yyline, yytext()); }

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
		return new Symbol(TablaSimbolos.cadena, yycolumn, yyline, strTemporal);
	}
	[^"\""]				{   strCadena += yytext();  }
}
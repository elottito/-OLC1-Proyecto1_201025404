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
	
	/**
	* Metodo que muestra indiviualmente los tokens encontrados
	* @param lexema Lexema
	* @param fila Fila
	* @param columna Columna
	* @param tipo Tipo de Token
	*/
	public void finToken(String lexema, int fila, int columna, String tipo){
		System.out.println("[" + fila + 1 + "," + columna + 1 + "]\tToken: [" + tipo + "]\tLexema: [" + lexema + "]" );
	}

	/**
	* Metodo que almacena los errores lexicos que se encuentren
	* @param lexema Lexema.
	* @param fila Fila.
	* @param columna Columna.
	*/
	public void findErrorLexico(String lexema, int fila, int columna){
		System.out.println("Error Lexico: -----> " + lexema + "\t[" + fila + 1 + "," + columna + 1 + "]");
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
	{CONJ} 				{	finToken(yytext(), yyline, yycolumn, "Palabra Res");	return new Symbol(TablaSimbolos.CONJ, yycolumn, yyline + 1, yytext()); 
	}

	// Simbolos
	{COMA}				{	finToken(yytext(), yyline, yycolumn, "Coma");			return new Symbol(TablaSimbolos.COMA,			yycolumn, yyline + 1, yytext()); }
	{DOSPUNTOS}			{	finToken(yytext(), yyline, yycolumn, "DosPuntos");		return new Symbol(TablaSimbolos.DOSPUNTOS,		yycolumn, yyline + 1, yytext()); }
	{FLECHA}			{	finToken(yytext(), yyline, yycolumn, "Flecha");			return new Symbol(TablaSimbolos.FLECHA,			yycolumn, yyline + 1, yytext()); }
	{LLAVE_A}			{	finToken(yytext(), yyline, yycolumn, "Llave_A");		return new Symbol(TablaSimbolos.LLAVE_A,		yycolumn, yyline + 1, yytext()); }
	{LLAVE_C}			{	finToken(yytext(), yyline, yycolumn, "Llave_C");		return new Symbol(TablaSimbolos.LLAVE_C,		yycolumn, yyline + 1, yytext()); }
	{PUNTOCOMA}			{	finToken(yytext(), yyline, yycolumn, "PuntoComa");		return new Symbol(TablaSimbolos.PUNTOCOMA,		yycolumn, yyline + 1, yytext()); }
	{PORCENTAJE}		{	finToken(yytext(), yyline, yycolumn, "Porcentaje");		return new Symbol(TablaSimbolos.PORCENTAJE,		yycolumn, yyline + 1, yytext()); }
	{VIRGULILLA}		{	finToken(yytext(), yyline, yycolumn, "Virgulilla");		return new Symbol(TablaSimbolos.VIRGULILLA,		yycolumn, yyline + 1, yytext()); }

	//Operadores
	{PUNTO}				{	finToken(yytext(), yyline, yycolumn, "Punto");			return new Symbol(TablaSimbolos.PUNTO,			yycolumn, yyline + 1, yytext()); }
	{BARRA}				{	finToken(yytext(), yyline, yycolumn, "Barra");			return new Symbol(TablaSimbolos.BARRA,			yycolumn, yyline + 1, yytext()); }
	{POR}				{	finToken(yytext(), yyline, yycolumn, "Por");			return new Symbol(TablaSimbolos.POR,			yycolumn, yyline + 1, yytext()); }
	{MAS}				{	finToken(yytext(), yyline, yycolumn, "Mas");			return new Symbol(TablaSimbolos.MAS,			yycolumn, yyline + 1, yytext()); }
	{INTER}				{	finToken(yytext(), yyline, yycolumn, "Inter");			return new Symbol(TablaSimbolos.INTER,			yycolumn, yyline + 1, yytext()); }

	//Simbolos Especiales
	{SALTO_LINEA}		{	finToken(yytext(), yyline, yycolumn, "Salto Linea");	return new Symbol(TablaSimbolos.SALTO_LINEA,	yycolumn, yyline + 1, yytext()); }
	{SIM_COM_DOB}		{	finToken(yytext(), yyline, yycolumn, "ComillaDoble");	return new Symbol(TablaSimbolos.SIM_COM_DOB,	yycolumn, yyline + 1, yytext()); }
	{SIM_COM_SIM}		{	finToken(yytext(), yyline, yycolumn, "ComillaSimple");	return new Symbol(TablaSimbolos.SIM_COM_SIM,	yycolumn, yyline + 1, yytext()); }

	// Cadena
	{COMILLA}			{	yybegin(CADENA);	}

	// Expresiones Regulares
	{NUMERO}			{	finToken(yytext(), yyline, yycolumn, "Numero");			return new Symbol(TablaSimbolos.NUMERO, 		yycolumn, yyline + 1, yytext()); }
	{ID}				{	finToken(yytext(), yyline, yycolumn, "Id");				return new Symbol(TablaSimbolos.ID, 			yycolumn, yyline + 1, yytext()); }
	{SIMBOLO}			{	finToken(yytext(), yyline, yycolumn, "Otro Simbolo");	return new Symbol(TablaSimbolos.SIMBOLO, 		yycolumn, yyline + 1, yytext()); 
						}

	// Espacios en Blanco
	{BLANCOS}			{	/* Se Ignoran los Espacios en Blanco*/	}
	{COMENTARIOS}		{	/* Se Ignoran los Comentarios*/			}

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
		finToken(strTemporal, yyline, yycolumn, "Cadena");
		return new Symbol(TablaSimbolos.CADENA, yycolumn, yyline + 1, strTemporal);
	}
	[^"\""]				{   strCadena += yytext();  }
}
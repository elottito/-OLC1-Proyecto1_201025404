
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.usac.olc1.analizadores;

import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class AnalizadorSintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return TablaSimbolos.class;
}

  /** Default constructor. */
  @Deprecated
  public AnalizadorSintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public AnalizadorSintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\061\000\002\002\004\000\002\002\007\000\002\003" +
    "\004\000\002\003\003\000\002\004\003\000\002\004\003" +
    "\000\002\006\004\000\002\006\003\000\002\007\010\000" +
    "\002\010\003\000\002\010\003\000\002\010\003\000\002" +
    "\011\005\000\002\012\005\000\002\012\003\000\002\013" +
    "\006\000\002\014\005\000\002\014\005\000\002\014\004" +
    "\000\002\014\004\000\002\014\004\000\002\014\005\000" +
    "\002\014\003\000\002\014\003\000\002\014\003\000\002" +
    "\015\006\000\002\015\003\000\002\005\006\000\002\005" +
    "\003\000\002\016\003\000\002\016\003\000\002\017\003" +
    "\000\002\017\003\000\002\017\003\000\002\017\003\000" +
    "\002\017\003\000\002\017\003\000\002\017\003\000\002" +
    "\017\003\000\002\017\003\000\002\017\003\000\002\017" +
    "\003\000\002\017\003\000\002\017\003\000\002\017\003" +
    "\000\002\017\003\000\002\020\003\000\002\020\003\000" +
    "\002\020\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\120\000\004\010\005\001\002\000\004\002\122\001" +
    "\002\000\010\004\014\027\007\031\006\001\002\000\010" +
    "\005\uffe4\007\uffe4\011\uffe4\001\002\000\010\005\uffe3\007" +
    "\uffe3\011\uffe3\001\002\000\014\003\ufffd\004\ufffd\013\ufffd" +
    "\027\ufffd\031\ufffd\001\002\000\014\003\ufffc\004\ufffc\013" +
    "\ufffc\027\ufffc\031\ufffc\001\002\000\014\003\104\004\014" +
    "\013\103\027\007\031\006\001\002\000\004\005\055\001" +
    "\002\000\004\007\016\001\002\000\014\003\ufffe\004\ufffe" +
    "\013\ufffe\027\ufffe\031\ufffe\001\002\000\006\027\007\031" +
    "\006\001\002\000\004\005\020\001\002\000\046\003\041" +
    "\006\033\007\023\010\045\011\042\012\044\013\032\015" +
    "\021\016\027\017\030\020\047\021\046\022\036\023\034" +
    "\024\035\025\043\027\024\030\040\001\002\000\010\006" +
    "\uffd9\012\uffd9\014\uffd9\001\002\000\010\006\uffd4\012\uffd4" +
    "\014\uffd4\001\002\000\010\006\uffde\012\uffde\014\uffde\001" +
    "\002\000\010\006\uffe2\012\uffe2\014\uffe2\001\002\000\006" +
    "\006\053\012\ufff7\001\002\000\004\012\ufff8\001\002\000" +
    "\010\006\uffd8\012\uffd8\014\uffd8\001\002\000\010\006\uffd7" +
    "\012\uffd7\014\uffd7\001\002\000\010\006\ufff3\012\ufff3\014" +
    "\051\001\002\000\010\006\uffda\012\uffda\014\uffda\001\002" +
    "\000\010\006\uffdf\012\uffdf\014\uffdf\001\002\000\036\003" +
    "\uffd3\006\uffd3\010\uffd3\012\uffd3\014\uffd3\015\uffd3\016\uffd3" +
    "\017\uffd3\020\uffd3\021\uffd3\023\uffd3\024\uffd3\025\uffd3\026" +
    "\uffd3\001\002\000\036\003\uffd2\006\uffd2\010\uffd2\012\uffd2" +
    "\014\uffd2\015\uffd2\016\uffd2\017\uffd2\020\uffd2\021\uffd2\023" +
    "\uffd2\024\uffd2\025\uffd2\026\uffd2\001\002\000\010\006\uffe0" +
    "\012\uffe0\014\uffe0\001\002\000\004\012\050\001\002\000" +
    "\010\006\uffe1\012\uffe1\014\uffe1\001\002\000\004\012\ufff6" +
    "\001\002\000\010\006\uffdc\012\uffdc\014\uffdc\001\002\000" +
    "\036\003\uffd1\006\uffd1\010\uffd1\012\uffd1\014\uffd1\015\uffd1" +
    "\016\uffd1\017\uffd1\020\uffd1\021\uffd1\023\uffd1\024\uffd1\025" +
    "\uffd1\026\uffd1\001\002\000\010\006\uffdb\012\uffdb\014\uffdb" +
    "\001\002\000\010\006\uffdd\012\uffdd\014\uffdd\001\002\000" +
    "\010\006\uffd5\012\uffd5\014\uffd5\001\002\000\010\006\uffd6" +
    "\012\uffd6\014\uffd6\001\002\000\014\003\ufff9\004\ufff9\013" +
    "\ufff9\027\ufff9\031\ufff9\001\002\000\044\006\033\007\023" +
    "\010\045\011\042\012\044\013\032\015\021\016\027\017" +
    "\030\020\047\021\046\022\036\023\034\024\035\025\043" +
    "\027\024\030\040\001\002\000\004\012\ufff5\001\002\000" +
    "\044\006\033\007\023\010\045\011\042\012\044\013\032" +
    "\015\021\016\027\017\030\020\047\021\046\022\036\023" +
    "\034\024\035\025\043\027\024\030\040\001\002\000\006" +
    "\006\ufff4\012\ufff4\001\002\000\030\003\064\010\063\015" +
    "\057\016\065\017\060\020\062\021\067\023\034\024\035" +
    "\025\043\026\056\001\002\000\032\003\uffeb\010\uffeb\012" +
    "\uffeb\015\uffeb\016\uffeb\017\uffeb\020\uffeb\021\uffeb\023\uffeb" +
    "\024\uffeb\025\uffeb\026\uffeb\001\002\000\030\003\064\010" +
    "\063\015\057\016\065\017\060\020\062\021\067\023\034" +
    "\024\035\025\043\026\056\001\002\000\030\003\064\010" +
    "\063\015\057\016\065\017\060\020\062\021\067\023\034" +
    "\024\035\025\043\026\056\001\002\000\032\003\uffea\010" +
    "\uffea\012\uffea\015\uffea\016\uffea\017\uffea\020\uffea\021\uffea" +
    "\023\uffea\024\uffea\025\uffea\026\uffea\001\002\000\030\003" +
    "\064\010\063\015\057\016\065\017\060\020\062\021\067" +
    "\023\034\024\035\025\043\026\056\001\002\000\006\027" +
    "\007\031\006\001\002\000\032\003\uffe9\010\uffe9\012\uffe9" +
    "\015\uffe9\016\uffe9\017\uffe9\020\uffe9\021\uffe9\023\uffe9\024" +
    "\uffe9\025\uffe9\026\uffe9\001\002\000\030\003\064\010\063" +
    "\015\057\016\065\017\060\020\062\021\067\023\034\024" +
    "\035\025\043\026\056\001\002\000\004\012\071\001\002" +
    "\000\030\003\064\010\063\015\057\016\065\017\060\020" +
    "\062\021\067\023\034\024\035\025\043\026\056\001\002" +
    "\000\032\003\uffed\010\uffed\012\uffed\015\uffed\016\uffed\017" +
    "\uffed\020\uffed\021\uffed\023\uffed\024\uffed\025\uffed\026\uffed" +
    "\001\002\000\014\003\ufff2\004\ufff2\013\ufff2\027\ufff2\031" +
    "\ufff2\001\002\000\030\003\064\010\063\015\057\016\065" +
    "\017\060\020\062\021\067\023\034\024\035\025\043\026" +
    "\056\001\002\000\032\003\ufff0\010\ufff0\012\ufff0\015\ufff0" +
    "\016\ufff0\017\ufff0\020\ufff0\021\ufff0\023\ufff0\024\ufff0\025" +
    "\ufff0\026\ufff0\001\002\000\004\011\075\001\002\000\032" +
    "\003\uffec\010\uffec\012\uffec\015\uffec\016\uffec\017\uffec\020" +
    "\uffec\021\uffec\023\uffec\024\uffec\025\uffec\026\uffec\001\002" +
    "\000\032\003\uffee\010\uffee\012\uffee\015\uffee\016\uffee\017" +
    "\uffee\020\uffee\021\uffee\023\uffee\024\uffee\025\uffee\026\uffee" +
    "\001\002\000\032\003\uffef\010\uffef\012\uffef\015\uffef\016" +
    "\uffef\017\uffef\020\uffef\021\uffef\023\uffef\024\uffef\025\uffef" +
    "\026\uffef\001\002\000\030\003\064\010\063\015\057\016" +
    "\065\017\060\020\062\021\067\023\034\024\035\025\043" +
    "\026\056\001\002\000\032\003\ufff1\010\ufff1\012\ufff1\015" +
    "\ufff1\016\ufff1\017\ufff1\020\ufff1\021\ufff1\023\ufff1\024\ufff1" +
    "\025\ufff1\026\ufff1\001\002\000\014\003\uffff\004\uffff\013" +
    "\uffff\027\uffff\031\uffff\001\002\000\004\013\117\001\002" +
    "\000\010\003\uffe5\027\uffe5\031\uffe5\001\002\000\010\003" +
    "\106\027\007\031\006\001\002\000\012\003\uffe7\011\uffe7" +
    "\027\uffe7\031\uffe7\001\002\000\012\003\106\011\115\027" +
    "\007\031\006\001\002\000\004\007\112\001\002\000\012" +
    "\003\ufffa\011\ufffa\027\ufffa\031\ufffa\001\002\000\004\026" +
    "\113\001\002\000\004\012\114\001\002\000\012\003\uffe8" +
    "\011\uffe8\027\uffe8\031\uffe8\001\002\000\004\002\000\001" +
    "\002\000\012\003\ufffb\011\ufffb\027\ufffb\031\ufffb\001\002" +
    "\000\004\013\120\001\002\000\004\013\121\001\002\000" +
    "\010\003\uffe6\027\uffe6\031\uffe6\001\002\000\004\002\001" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\120\000\004\002\003\001\001\000\002\001\001\000" +
    "\014\003\011\004\014\007\007\013\010\016\012\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\014\004\101\005\104\007\007\013\010" +
    "\016\012\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\016\016\001\001\000\002\001\001" +
    "\000\014\010\036\011\025\012\024\017\030\020\021\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\017\051\020\021\001" +
    "\001\000\002\001\001\000\006\017\053\020\021\001\001" +
    "\000\002\001\001\000\006\014\065\020\060\001\001\000" +
    "\002\001\001\000\006\014\077\020\060\001\001\000\006" +
    "\014\076\020\060\001\001\000\002\001\001\000\006\014" +
    "\075\020\060\001\001\000\004\016\073\001\001\000\002" +
    "\001\001\000\006\014\071\020\060\001\001\000\002\001" +
    "\001\000\006\014\067\020\060\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\014\072\020\060\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\014\100\020\060\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\010\006\106\015\110\016\107\001" +
    "\001\000\002\001\001\000\006\015\115\016\107\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



	// Metodo al que se llama automaticamente ante algun error sintactico.
	public void syntax_error(Symbol s){
		int fila = s.right + 1;
		int columna = s.left + 1;
		String lexema = (String) s.value;
		System.err.println("Error Sintactico (Recuperado)\tLexema [" + lexema + "]\tUbicacion: [" + fila + "," + columna + "]");
	}

	// Metodo al que se llama en el momento en que ya no es posible una recuperacion de errores.
	public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
		int fila = s.right + 1;
		int columna = s.left + 1;
		String lexema = (String) s.value;
		System.out.println("Error Sintactico (No Recuperable) Lexema [" + lexema + "]\tUbicacion: [" + fila + "," + columna + "]");
	}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$AnalizadorSintactico$actions {


	// Codigo para las acciones gramaticales

  private final AnalizadorSintactico parser;

  /** Constructor */
  CUP$AnalizadorSintactico$actions(AnalizadorSintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintactico$do_action_part00000000(
    int                        CUP$AnalizadorSintactico$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintactico$parser,
    java.util.Stack            CUP$AnalizadorSintactico$stack,
    int                        CUP$AnalizadorSintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintactico$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintactico$parser.done_parsing();
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= LLAVE_A lista_stmt separador lista_validar LLAVE_C 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-4)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // lista_stmt ::= lista_stmt stmt 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("lista_stmt",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // lista_stmt ::= stmt 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("lista_stmt",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // stmt ::= conjunto 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("stmt",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // stmt ::= expreRegular 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("stmt",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // lista_validar ::= lista_validar validar 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("lista_validar",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // lista_validar ::= validar 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("lista_validar",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // conjunto ::= CONJ DOSPUNTOS identificador FLECHA definicion PUNTOCOMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("conjunto",5, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-5)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // definicion ::= intervalo 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("definicion",6, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // definicion ::= listaCaracter 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("definicion",6, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // definicion ::= error 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("definicion",6, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // intervalo ::= caracter VIRGULILLA caracter 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("intervalo",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // listaCaracter ::= listaCaracter COMA caracter 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("listaCaracter",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // listaCaracter ::= caracter 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("listaCaracter",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // expreRegular ::= identificador FLECHA expr PUNTOCOMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expreRegular",9, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // expr ::= PUNTO expr expr 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // expr ::= BARRA expr expr 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expr ::= POR expr 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expr ::= MAS expr 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expr ::= INTER expr 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expr ::= LLAVE_A identificador LLAVE_C 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expr ::= CADENA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // expr ::= especial 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // expr ::= error 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("expr",10, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // validar ::= identificador DOSPUNTOS CADENA PUNTOCOMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("validar",11, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // validar ::= error 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("validar",11, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // separador ::= PORCENTAJE PORCENTAJE PORCENTAJE PORCENTAJE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("separador",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // separador ::= error 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("separador",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // identificador ::= ID 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("identificador",12, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // identificador ::= LETRA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("identificador",12, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // caracter ::= LETRA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // caracter ::= NUMERO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // caracter ::= SIMBOLO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // caracter ::= COMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // caracter ::= DOSPUNTOS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // caracter ::= LLAVE_A 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // caracter ::= LLAVE_C 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // caracter ::= PUNTOCOMA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // caracter ::= PORCENTAJE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // caracter ::= PUNTO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // caracter ::= BARRA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // caracter ::= POR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // caracter ::= MAS 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // caracter ::= INTER 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // caracter ::= especial 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("caracter",13, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // especial ::= SIM_COM_DOB 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("especial",14, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 47: // especial ::= SIM_COM_SIM 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("especial",14, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 48: // especial ::= SALTO_LINEA 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("especial",14, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$AnalizadorSintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintactico$do_action(
    int                        CUP$AnalizadorSintactico$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintactico$parser,
    java.util.Stack            CUP$AnalizadorSintactico$stack,
    int                        CUP$AnalizadorSintactico$top)
    throws java.lang.Exception
    {
              return CUP$AnalizadorSintactico$do_action_part00000000(
                               CUP$AnalizadorSintactico$act_num,
                               CUP$AnalizadorSintactico$parser,
                               CUP$AnalizadorSintactico$stack,
                               CUP$AnalizadorSintactico$top);
    }
}

}

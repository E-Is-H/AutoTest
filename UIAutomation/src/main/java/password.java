import java.util.ArrayList;
import java.util.Scanner;

public class password {

public String fengzhuang(String s ){
    if(s.equals("A")){
        s="X";
    }else if(s.equals("B")){
        s="Y";
    }else if(s.equals("C")){
        s="Z";
    }else if(s.equals("D")){
        s="K";
    }else if(s.equals("E")){
        s="L";
    }else if(s.equals("F")){
        s="M";
    }else if(s.equals("G")){
        s="N";
    }else if(s.equals("H")){
        s="O";
    }else if(s.equals("I")){
        s="P";
    }else if(s.equals("J")){
        s="Q";
    }else if(s.equals("K")){
        s="R";
    }else if(s.equals("L")){
        s="S";
    }else if(s.equals("M")){
        s="T";
    }else if(s.equals("N")){
        s="U";
    }else if(s.equals("O")){
        s="V";
    }else if(s.equals("P")){
        s="W";
    }else if(s.equals("Q")){
        s="A";
    }else if(s.equals("R")){
        s="B";
    }else if(s.equals("S")){
        s="C";
    }else if(s.equals("T")){
        s="D";
    }else if(s.equals("U")){
        s="E";
    }else if(s.equals("V")){
        s="F";
    }else if(s.equals("W")){
        s="G";
    }else if(s.equals("X")){
        s="H";
    }else if(s.equals("Y")){
        s="I";
    }else if(s.equals("Z")){
        s="J";
    }else if(s.equals("0")){
        s="7";
    }else if(s.equals("1")){
        s="8";
    }else if(s.equals("2")){
        s="9";
    }else if(s.equals("3")){
        s="0";
    }else if(s.equals("4")){
        s="1";
    }else if(s.equals("5")){
        s="2";
    }else if(s.equals("6")){
        s="3";
    }else if(s.equals("7")){
        s="4";
    }else if(s.equals("8")){
        s="5";
    }else if(s.equals("9")){
        s="6";
    }else if(s.equals("!")){
        s="%";
    }else if(s.equals("@")){
        s="^";
    }else if(s.equals("#")){
        s="&";
    }else if(s.equals("$")){
        s="*";
    }else if(s.equals("%")){
        s=".";
    }else if(s.equals("^")){
        s="!";
    }else if(s.equals("&")){
        s="@";
    }else if(s.equals("*")){
        s="#";
    }else if(s.equals(".")){
        s="$";
    }else if(s.equals("a")){
        s="x";
    }else if(s.equals("b")){
        s="y";
    }else if(s.equals("c")){
        s="z";
    }else if(s.equals("d")){
        s="k";
    }else if(s.equals("e")){
        s="l";
    }else if(s.equals("f")){
        s="m";
    }else if(s.equals("g")){
        s="n";
    }else if(s.equals("h")){
        s="o";
    }else if(s.equals("i")){
        s="p";
    }else if(s.equals("j")){
        s="q";
    }else if(s.equals("k")){
        s="r";
    }else if(s.equals("l")){
        s="s";
    }else if(s.equals("m")){
        s="t";
    }else if(s.equals("n")){
        s="u";
    }else if(s.equals("o")){
        s="v";
    }else if(s.equals("p")){
        s="w";
    }else if(s.equals("q")){
        s="a";
    }else if(s.equals("r")){
        s="b";
    }else if(s.equals("s")){
        s="c";
    }else if(s.equals("t")){
        s="d";
    }else if(s.equals("u")){
        s="e";
    }else if(s.equals("v")){
        s="f";
    }else if(s.equals("w")){
        s="g";
    }else if(s.equals("x")){
        s="h";
    }else if(s.equals("y")){
        s="i";
    }else if(s.equals("z")){
        s="j";
    }
    return  s;
}
    public String fengzhuang1(String s ){
        if(s.equals("X")){
            s="A";
        }else if(s.equals("Y")){
            s="B";
        }else if(s.equals("Z")){
            s="C";
        }else if(s.equals("K")){
            s="D";
        }else if(s.equals("L")){
            s="E";
        }else if(s.equals("M")){
            s="F";
        }else if(s.equals("N")){
            s="G";
        }else if(s.equals("O")){
            s="H";
        }else if(s.equals("P")){
            s="I";
        }else if(s.equals("Q")){
            s="J";
        }else if(s.equals("R")){
            s="K";
        }else if(s.equals("S")){
            s="L";
        }else if(s.equals("T")){
            s="M";
        }else if(s.equals("U")){
            s="N";
        }else if(s.equals("V")){
            s="O";
        }else if(s.equals("W")){
            s="P";
        }else if(s.equals("A")){
            s="Q";
        }else if(s.equals("B")){
            s="R";
        }else if(s.equals("C")){
            s="S";
        }else if(s.equals("D")){
            s="T";
        }else if(s.equals("E")){
            s="U";
        }else if(s.equals("F")){
            s="V";
        }else if(s.equals("G")){
            s="W";
        }else if(s.equals("H")){
            s="X";
        }else if(s.equals("I")){
            s="Y";
        }else if(s.equals("J")){
            s="Z";
        }else if(s.equals("7")){
            s="0";
        }else if(s.equals("8")){
            s="1";
        }else if(s.equals("9")){
            s="2";
        }else if(s.equals("0")){
            s="3";
        }else if(s.equals("1")){
            s="4";
        }else if(s.equals("2")){
            s="5";
        }else if(s.equals("3")){
            s="6";
        }else if(s.equals("4")){
            s="7";
        }else if(s.equals("5")){
            s="8";
        }else if(s.equals("6")){
            s="9";
        }else if(s.equals("%")){
            s="!";
        }else if(s.equals("^")){
            s="@";
        }else if(s.equals("&")){
            s="#";
        }else if(s.equals("*")){
            s="$";
        }else if(s.equals(".")){
            s="%";
        }else if(s.equals("!")){
            s="^";
        }else if(s.equals("@")){
            s="&";
        }else if(s.equals("#")){
            s="*";
        }else if(s.equals("$")){
            s=".";
        }else if(s.equals("x")){
            s="a";
        }else if(s.equals("y")){
            s="b";
        }else if(s.equals("z")){
            s="c";
        }else if(s.equals("k")){
            s="d";
        }else if(s.equals("l")){
            s="e";
        }else if(s.equals("m")){
            s="f";
        }else if(s.equals("n")){
            s="g";
        }else if(s.equals("o")){
            s="h";
        }else if(s.equals("p")){
            s="i";
        }else if(s.equals("q")){
            s="j";
        }else if(s.equals("r")){
            s="k";
        }else if(s.equals("s")){
            s="l";
        }else if(s.equals("t")){
            s="m";
        }else if(s.equals("u")){
            s="n";
        }else if(s.equals("v")){
            s="o";
        }else if(s.equals("w")){
            s="p";
        }else if(s.equals("a")){
            s="q";
        }else if(s.equals("b")){
            s="r";
        }else if(s.equals("c")){
            s="s";
        }else if(s.equals("d")){
            s="t";
        }else if(s.equals("e")){
            s="u";
        }else if(s.equals("f")){
            s="v";
        }else if(s.equals("g")){
            s="w";
        }else if(s.equals("h")){
            s="x";
        }else if(s.equals("i")){
            s="y";
        }else if(s.equals("j")){
            s="z";
        }
        return  s;
    }

    public static void main(String[] args) {
        password pw = new password();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择");
        String xz = scanner.nextLine();
        while (xz.equals("1") || xz.equals("2")) {
            if (xz.equals("1")) {
                System.out.println("请输入");
                String password = scanner.nextLine();
                ArrayList<String> list = new ArrayList<String>();
                int jm = password.length();
                int jpw = 0;
                for (int i = 0; i < password.length(); i++) {
                    char a = password.charAt(jpw);
                    String sa = String.valueOf(a);
                    String po = pw.fengzhuang(sa);
                    list.add(po);
                    jpw = jpw + 1;
                }
                System.out.println(list);
                System.out.println("请选择");
                xz = scanner.nextLine();

            } else if (xz.equals("2")) {
                System.out.println("请输入");
                String password1 = scanner.nextLine();
                ArrayList<String> list = new ArrayList<String>();
                int jm = password1.length();
                int jpw = 0;
                for (int i = 0; i < password1.length(); i++) {
                    char a = password1.charAt(jpw);
                    String sa = String.valueOf(a);
                    String po = pw.fengzhuang1(sa);
                    list.add(po);
                    jpw = jpw + 1;
                }
                System.out.println(list);
                System.out.println("请选择");
                xz = scanner.nextLine();
            }else {
                break;
            }

        }
    }


    }


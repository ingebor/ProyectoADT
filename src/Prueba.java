import java.util.Scanner;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
class LObj {
    public Type tag() { return tag_; }
    public LObj(Type type, Object obj) {
        tag_ = type;
        data_ = obj;
    }
    public Integer num() {
        return (Integer)data_;
    }
    public String str() {
        return (String)data_;
    }
    public Cons cons() {
        return (Cons)data_;
    }
    public Subr subr() {
        return (Subr)data_;
    }
    public Expr expr() {
        return (Expr)data_;
    }

    @Override public String toString() {
        if (tag_ == Type.NIL) {
            return "nil";
        } else if (tag_ == Type.NUM) {
            return num().toString();
        } else if (tag_ == Type.SYM) {
            return str();
        } else if (tag_ == Type.ERROR) {
            return "<error: " + str() + ">";
        } else if (tag_ == Type.CONS) {
            return listToString(this);
        } else if (tag_ == Type.SUBR) {
            return "<subr>";
        } else if (tag_ == Type.EXPR) {
            return "<expr>";
        }
        return "<unknown>";
    }

    private String listToString(LObj obj) {
        String ret = "";
        boolean first = true;
        while (obj.tag() == Type.CONS) {
            if (first) {
                first = false;
            } else {
                ret += " ";
            }
            ret += obj.cons().car.toString();
            obj = obj.cons().cdr;
        }
        if (obj.tag() == Type.NIL) {
            return "(" + ret + ")";
        }
        return "(" + ret + " . " + obj.toString() + ")";
    }

    private Type tag_;
    private Object data_;
}

class Util {
    public static LObj makeNum(Integer num) {
        return new LObj(Type.NUM, num);
    }
    public static LObj makeError(String str) {
        return new LObj(Type.ERROR, str);
    }
    public static LObj makeCons(LObj a, LObj d) {
        return new LObj(Type.CONS, new Cons(a, d));
    }
    public static LObj makeSubr(Subr subr) {
        return new LObj(Type.SUBR, subr);
    }
    public static LObj makeExpr(LObj args, LObj env) {
        return new LObj(Type.EXPR, new Expr(safeCar(args), safeCdr(args), env));
    }
    public static LObj makeSym(String str) {
        if (str.equals("nil")) {
            return kNil;
        } else if (!symbolMap.containsKey(str)) {
            symbolMap.put(str, new LObj(Type.SYM, str));
        }
        return symbolMap.get(str);
    }

    public static LObj safeCar(LObj obj) {
        if (obj.tag() == Type.CONS) {
            return obj.cons().car;
        }
        return kNil;
    }
    public static LObj safeCdr(LObj obj) {
        if (obj.tag() == Type.CONS) {
            return obj.cons().cdr;
        }
        return kNil;
    }

    public static LObj nreverse(LObj lst) {
        LObj ret = kNil;
        while (lst.tag() == Type.CONS) {
            LObj tmp = lst.cons().cdr;
            lst.cons().cdr = ret;
            ret = lst;
            lst = tmp;
        }
        return ret;
    }

    public static LObj pairlis(LObj lst1, LObj lst2) {
        LObj ret = kNil;
        while (lst1.tag() == Type.CONS && lst2.tag() == Type.CONS) {
            ret = makeCons(makeCons(lst1.cons().car, lst2.cons().car), ret);
            lst1 = lst1.cons().cdr;
            lst2 = lst2.cons().cdr;
        }
        return nreverse(ret);
    }

    public final static LObj kNil = new LObj(Type.NIL, "nil");
    private static Map<String, LObj> symbolMap = new HashMap<String, LObj>();
}

public class Prueba{
	public static void main(String[] args) {
        InputStreamReader ireader = new InputStreamReader(System.in);
        BufferedReader breader = new BufferedReader(ireader);
        LObj gEnv = Evaluator.globalEnv();
        try {
            String line;
            System.out.print("> ");
            while ((line = breader.readLine()) != null) {
                System.out.print(Evaluator.eval(Reader.read(line).obj, gEnv));
            System.out.print("\n> ");
            }
        } catch (IOException e) {}
    }
	
	

}

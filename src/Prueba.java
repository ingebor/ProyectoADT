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

package lista7.java;
import lista7.scala.*;

public interface Visitor {
    void visit(Spoon spoon);
    void visit(Fork fork);
    void visit(Plate plate);
    void visit(Bowl bowl);
    void visit(Pan pan);
}

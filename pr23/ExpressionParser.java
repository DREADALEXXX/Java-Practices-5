// task4_parser/ExpressionParser.java
package task4_parser;

import java.util.*;

/**
 * Парсер выражений с переменными x, y, z, операциями + - * / ( ) и унарным минусом.
 * Приоритет: унарный минус > * / > + -.
 * Алгоритм — рекурсивный спуск, O(n).
 */
public class ExpressionParser {

    // === Внутренние классы-узлы ===
    private interface Node extends TripleExpression { }

    private record Const(int value) implements Node {
        @Override public int evaluate(int x, int y, int z) { return value; }
    }

    private record Var(String name) implements Node {
        @Override public int evaluate(int x, int y, int z) {
            return switch (name) {
                case "x" -> x;
                case "y" -> y;
                case "z" -> z;
                default  -> throw new IllegalArgumentException("Unknown variable: " + name);
            };
        }
    }

    private record BinOp(char op, Node left, Node right) implements Node {
        @Override public int evaluate(int x, int y, int z) {
            int a = left.evaluate(x, y, z);
            int b = right.evaluate(x, y, z);
            return switch (op) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                case '/' -> {
                    if (b == 0) throw new ArithmeticException("division by zero");
                    yield a / b;
                }
                default -> throw new IllegalStateException("Unknown op: " + op);
            };
        }
    }

    private record UnaryMinus(Node operand) implements Node {
        @Override public int evaluate(int x, int y, int z) {
            return -operand.evaluate(x, y, z);
        }
    }

    // === Лексер / позиция ===
    private String src;
    private int pos;

    public TripleExpression parse(String expression) {
        if (expression == null) throw new IllegalArgumentException("Expression is null");
        this.src = expression;
        this.pos = 0;
        Node result = parseExpression();
        skipWhitespace();
        if (pos != src.length())
            throw new IllegalArgumentException("Unexpected character at " + pos + ": " + src.charAt(pos));
        return result;
    }

    private Node parseExpression() {
        Node left = parseTerm();
        while (true) {
            skipWhitespace();
            if (peek() == '+' || peek() == '-') {
                char op = src.charAt(pos++);
                Node right = parseTerm();
                left = new BinOp(op, left, right);
            } else break;
        }
        return left;
    }

    private Node parseTerm() {
        Node left = parseFactor();
        while (true) {
            skipWhitespace();
            if (peek() == '*' || peek() == '/') {
                char op = src.charAt(pos++);
                Node right = parseFactor();
                left = new BinOp(op, left, right);
            } else break;
        }
        return left;
    }

    private Node parseFactor() {
        skipWhitespace();
        if (peek() == '-') {
            pos++;
            return new UnaryMinus(parseFactor());
        }
        if (peek() == '(') {
            pos++;
            Node inner = parseExpression();
            skipWhitespace();
            if (peek() != ')') throw new IllegalArgumentException("Expected ')' at " + pos);
            pos++;
            return inner;
        }
        if (Character.isDigit(peek())) return parseNumber();
        if (Character.isLetter(peek())) return parseVariable();
        throw new IllegalArgumentException("Unexpected character at " + pos + ": " + peek());
    }

    private Node parseNumber() {
        int start = pos;
        while (pos < src.length() && Character.isDigit(src.charAt(pos))) pos++;
        int value = Integer.parseInt(src.substring(start, pos));
        return new Const(value);
    }

    private Node parseVariable() {
        int start = pos;
        while (pos < src.length() && Character.isLetter(src.charAt(pos))) pos++;
        String name = src.substring(start, pos);
        return new Var(name);
    }

    private void skipWhitespace() {
        while (pos < src.length() && Character.isWhitespace(src.charAt(pos))) pos++;
    }

    private char peek() { return pos < src.length() ? src.charAt(pos) : '\0'; }
}
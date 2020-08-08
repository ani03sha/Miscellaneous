package org.redquark.practice.leetcode.medium;

/**
 * @author Anirudh Sharma
 * <p>
 * HTML entity parser is the parser that takes HTML code as input and replace all the entities of the special characters by the characters itself.
 * <p>
 * The special characters and their entities for HTML are:
 * <p>
 * Quotation Mark: the entity is &quot; and symbol character is ".
 * Single Quote Mark: the entity is &apos; and symbol character is '.
 * Ampersand: the entity is &amp; and symbol character is &.
 * Greater Than Sign: the entity is &gt; and symbol character is >.
 * Less Than Sign: the entity is &lt; and symbol character is <.
 * Slash: the entity is &frasl; and symbol character is /.
 * Given the input text string to the HTML parser, you have to implement the entity parser.
 * <p>
 * Return the text after replacing the entities by the special characters.
 */
public class Problem1410_HTMLEntityParser {

    private static String entityParser(String text) {
        StringBuilder result = new StringBuilder();
        int n = text.length();
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) != '&') {
                result.append(text.charAt(i));
            } else {
                if (i + 6 < n && text.startsWith("&quot;", i)) {
                    result.append("\"");
                    i += 5;
                } else if (i + 6 < n && text.startsWith("&apos;", i)) {
                    result.append("'");
                    i += 5;
                } else if (i + 5 < n && text.startsWith("&amp;", i)) {
                    result.append("&");
                    i += 4;
                } else if (i + 4 < n && text.startsWith("&gt;", i)) {
                    result.append(">");
                    i += 3;
                } else if (i + 4 < n && text.startsWith("&lt;", i)) {
                    result.append("<");
                    i += 3;
                } else if (i + 7 < n && text.startsWith("&frasl;", i)) {
                    result.append("/");
                    i += 6;
                } else {
                    result.append(text.charAt(i));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "&amp; is an HTML entity but &ambassador; is not.";
        System.out.println("Output: " + entityParser(s));
        s = "and I quote: &quot;...&quot;";
        System.out.println("Output: " + entityParser(s));
        s = "Stay home! Practice on Leetcode :)";
        System.out.println("Output: " + entityParser(s));
        s = "x &gt; y &amp;&amp; x &lt; y is always false";
        System.out.println("Output: " + entityParser(s));
        s = "leetcode.com&frasl;problemset&frasl;all";
        System.out.println("Output: " + entityParser(s));
        s = "&amp;gt;";
        System.out.println("Output: " + entityParser(s));
    }
}

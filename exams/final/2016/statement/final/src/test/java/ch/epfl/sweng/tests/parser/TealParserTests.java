package ch.epfl.sweng.tests.parser;

import ch.epfl.sweng.nodes.*;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import ch.epfl.sweng.TealFunction;
import ch.epfl.sweng.TealLibrary;
import ch.epfl.sweng.parser.TealParseException;
import ch.epfl.sweng.parser.TealParser;
import org.junit.internal.runners.statements.ExpectException;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Tests for the Teal parser.
 */
public final class TealParserTests {
    /**
     * NOTE: DO NOT REMOVE THIS TEST!
     *
     * This test is needed so that you can obtain 100% line coverage (JaCoCo bug).
     */
    @Test
    public void callPrivateConstructors() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<TealParser> c = TealParser.class.getDeclaredConstructor();
        c.setAccessible(true);
        c.newInstance();
    }

    // TODO: Add your own tests
    @Test (expected = IllegalArgumentException.class)
    public void parseNull() throws TealParseException {
        TealParser.parse(null);
    }

    @Test
    public void noFunctions() throws TealParseException{
        final TealLibrary library = TealParser.parse("");
        assertThat(library.functions.entrySet(), hasSize(0));
    }

    @Test (expected = TealParseException.class)
    public void existingFunctionName() throws TealParseException{
        TealParser.parse("f(n): n + 1 \n f(n): n + 2");
    }

    @Test (expected = TealParseException.class)
    public void leftoverInput() throws TealParseException{
        TealParser.parse("f(n): n + 1 \n g(n): n + 2fgdjhwe");
    }

    @Test (expected = TealParseException.class)
    public void invalidFunctionCalled() throws TealParseException{
        TealParser.parse("g(n): !3(2 + n)");
    }

    @Test (expected = TealParseException.class)
    public void badInt() throws TealParseException{
        TealParser.parse("g(): +3");
    }

    @Test
    public void parseFunctionCall() throws TealParseException{
        final TealLibrary library = TealParser.parse("g(n): !f(2 + n)");
        assertThat(library.functions.entrySet(), hasSize(1));
        assertThat(library, hasFunction("g", "n",
                new TealFunctionCallNode("f",
                        new TealAdditionNode(
                                new TealPrimitiveNode(2),
                                new TealVariableNode("n")))));
    }

    @Test
    public void identityFunction() throws TealParseException {
        final TealLibrary library = TealParser.parse("f(n): n");

        assertThat(library.functions.entrySet(), hasSize(1));
        assertThat(library, hasFunction("f", "n", new TealVariableNode("n")));
    }

    /**
     * Matches one function from a Teal library.
     *
     * @param functionName  The function's name.
     * @param parameterName The name of the function's parameter, or `null` if there is no parameter.
     * @param body          The function's body.
     * @return A matcher with the given values.
     */
    private static Matcher<TealLibrary> hasFunction(final String functionName,
                                                    final String parameterName,
                                                    final TealNode body) {
        return new FunctionMatcher(functionName, parameterName, body);
    }

    /**
     * Matcher for a function from a Teal library.
     * (You do not need to understand, or even read, this code!)
     */
    private static final class FunctionMatcher extends TypeSafeDiagnosingMatcher<TealLibrary> {
        private final String functionName;
        private final String parameterName;
        private final TealNode body;

        FunctionMatcher(final String functionName, final String parameterName, final TealNode body) {
            this.functionName = functionName;
            this.parameterName = parameterName;
            this.body = body;
        }

        @Override
        protected boolean matchesSafely(final TealLibrary item, final Description mismatchDescription) {
            if (!item.functions.containsKey(functionName)) {
                mismatchDescription.appendText("No function with that name exists in the library.");
            }

            final TealFunction function = item.functions.get(functionName);
            boolean result = true;
            if (parameterName == null && function.parameter != null) {
                mismatchDescription.appendText("The function had a parameter named '" + function.parameter + "'.");
                mismatchDescription.appendText(System.lineSeparator());
                result = false;
            }
            if (parameterName != null && function.parameter == null) {
                mismatchDescription.appendText("The function had no parameter.");
                mismatchDescription.appendText(System.lineSeparator());
                result = false;
            }
            if (parameterName != null && !parameterName.equals(function.parameter)) {
                mismatchDescription.appendText("The function's parameter was named '" + function.parameter + "'.");
                mismatchDescription.appendText(System.lineSeparator());
                result = false;
            }

            if (body.equals(function.body)) {
                return result;
            }

            mismatchDescription.appendText("The body was " + function.body);
            return false;
        }

        @Override
        public void describeTo(final Description description) {
            description.appendText("A function with name '" + functionName + "', ");

            if (parameterName == null) {
                description.appendText("no parameter, ");
            } else {
                description.appendText("parameter '" + parameterName + "', ");
            }

            description.appendText("and body " + body.toString());
        }
    }
}

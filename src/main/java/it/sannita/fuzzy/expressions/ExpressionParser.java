package it.sannita.fuzzy.expressions;

import it.sannita.exparser.configuration.ConfigFactory;
import it.sannita.exparser.configuration.SymbolsTable;
import it.sannita.exparser.model.fuzzy.FuzzyExpression;
import it.sannita.exparser.parser.FuzzyExpressionParser;
import it.sannita.fuzzy.models.FuzzyClass;
import it.sannita.fuzzy.models.FuzzyVariable;

public class ExpressionParser {

    private final FuzzyExpression expression;

    public ExpressionParser(String expression) throws Exception {
        SymbolsTable symbols = ConfigFactory.getConfigFromResource("symbols.json");
        FuzzyExpressionParser parser = new FuzzyExpressionParser(symbols);
        this.expression = parser.parse(expression);
    }

    double evaluate(FuzzyClass... classes){
        for(FuzzyClass fuzzyClass : classes){
           // fuzzyClass.getName()
        }

        return 0.0;
    }
}

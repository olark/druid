// Generated from io/druid/sql/antlr4/DruidSQL.g4 by ANTLR 4.0
package io.druid.sql.antlr4;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import io.druid.granularity.PeriodGranularity;
import io.druid.granularity.QueryGranularity;
import io.druid.query.aggregation.AggregatorFactory;
import io.druid.query.aggregation.CountAggregatorFactory;
import io.druid.query.aggregation.DoubleSumAggregatorFactory;
import io.druid.query.aggregation.MaxAggregatorFactory;
import io.druid.query.aggregation.MinAggregatorFactory;
import io.druid.query.aggregation.PostAggregator;
import io.druid.query.aggregation.post.ArithmeticPostAggregator;
import io.druid.query.aggregation.post.ConstantPostAggregator;
import io.druid.query.aggregation.post.FieldAccessPostAggregator;
import io.druid.query.dimension.DefaultDimensionSpec;
import io.druid.query.dimension.DimensionSpec;
import io.druid.query.filter.AndDimFilter;
import io.druid.query.filter.DimFilter;
import io.druid.query.filter.NotDimFilter;
import io.druid.query.filter.OrDimFilter;
import io.druid.query.filter.RegexDimFilter;
import io.druid.query.filter.SelectorDimFilter;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class DruidSQLBaseListener implements DruidSQLListener {
	@Override public void enterExpression(DruidSQLParser.ExpressionContext ctx) { }
	@Override public void exitExpression(DruidSQLParser.ExpressionContext ctx) { }

	@Override public void enterTimeFilter(DruidSQLParser.TimeFilterContext ctx) { }
	@Override public void exitTimeFilter(DruidSQLParser.TimeFilterContext ctx) { }

	@Override public void enterOrDimFilter(DruidSQLParser.OrDimFilterContext ctx) { }
	@Override public void exitOrDimFilter(DruidSQLParser.OrDimFilterContext ctx) { }

	@Override public void enterGroupby_stmt(DruidSQLParser.Groupby_stmtContext ctx) { }
	@Override public void exitGroupby_stmt(DruidSQLParser.Groupby_stmtContext ctx) { }

	@Override public void enterAggregate(DruidSQLParser.AggregateContext ctx) { }
	@Override public void exitAggregate(DruidSQLParser.AggregateContext ctx) { }

	@Override public void enterConstant(DruidSQLParser.ConstantContext ctx) { }
	@Override public void exitConstant(DruidSQLParser.ConstantContext ctx) { }

	@Override public void enterAndDimFilter(DruidSQLParser.AndDimFilterContext ctx) { }
	@Override public void exitAndDimFilter(DruidSQLParser.AndDimFilterContext ctx) { }

	@Override public void enterQuery(DruidSQLParser.QueryContext ctx) { }
	@Override public void exitQuery(DruidSQLParser.QueryContext ctx) { }

	@Override public void enterUnaryExpression(DruidSQLParser.UnaryExpressionContext ctx) { }
	@Override public void exitUnaryExpression(DruidSQLParser.UnaryExpressionContext ctx) { }

	@Override public void enterGranularityFn(DruidSQLParser.GranularityFnContext ctx) { }
	@Override public void exitGranularityFn(DruidSQLParser.GranularityFnContext ctx) { }

	@Override public void enterAdditiveExpression(DruidSQLParser.AdditiveExpressionContext ctx) { }
	@Override public void exitAdditiveExpression(DruidSQLParser.AdditiveExpressionContext ctx) { }

	@Override public void enterTimeAndDimFilter(DruidSQLParser.TimeAndDimFilterContext ctx) { }
	@Override public void exitTimeAndDimFilter(DruidSQLParser.TimeAndDimFilterContext ctx) { }

	@Override public void enterPrimaryExpression(DruidSQLParser.PrimaryExpressionContext ctx) { }
	@Override public void exitPrimaryExpression(DruidSQLParser.PrimaryExpressionContext ctx) { }

	@Override public void enterPrimaryDimFilter(DruidSQLParser.PrimaryDimFilterContext ctx) { }
	@Override public void exitPrimaryDimFilter(DruidSQLParser.PrimaryDimFilterContext ctx) { }

	@Override public void enterMultiplyExpression(DruidSQLParser.MultiplyExpressionContext ctx) { }
	@Override public void exitMultiplyExpression(DruidSQLParser.MultiplyExpressionContext ctx) { }

	@Override public void enterSelectorDimFilter(DruidSQLParser.SelectorDimFilterContext ctx) { }
	@Override public void exitSelectorDimFilter(DruidSQLParser.SelectorDimFilterContext ctx) { }

	@Override public void enterDimFilter(DruidSQLParser.DimFilterContext ctx) { }
	@Override public void exitDimFilter(DruidSQLParser.DimFilterContext ctx) { }

	@Override public void enterTimestamp(DruidSQLParser.TimestampContext ctx) { }
	@Override public void exitTimestamp(DruidSQLParser.TimestampContext ctx) { }

	@Override public void enterSelect_stmt(DruidSQLParser.Select_stmtContext ctx) { }
	@Override public void exitSelect_stmt(DruidSQLParser.Select_stmtContext ctx) { }

	@Override public void enterWhere_stmt(DruidSQLParser.Where_stmtContext ctx) { }
	@Override public void exitWhere_stmt(DruidSQLParser.Where_stmtContext ctx) { }

	@Override public void enterInListDimFilter(DruidSQLParser.InListDimFilterContext ctx) { }
	@Override public void exitInListDimFilter(DruidSQLParser.InListDimFilterContext ctx) { }

	@Override public void enterGroupByExpression(DruidSQLParser.GroupByExpressionContext ctx) { }
	@Override public void exitGroupByExpression(DruidSQLParser.GroupByExpressionContext ctx) { }

	@Override public void enterAliasedExpression(DruidSQLParser.AliasedExpressionContext ctx) { }
	@Override public void exitAliasedExpression(DruidSQLParser.AliasedExpressionContext ctx) { }

	@Override public void enterDatasource(DruidSQLParser.DatasourceContext ctx) { }
	@Override public void exitDatasource(DruidSQLParser.DatasourceContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}
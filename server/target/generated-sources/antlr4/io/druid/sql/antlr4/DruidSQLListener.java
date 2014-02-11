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

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface DruidSQLListener extends ParseTreeListener {
	void enterExpression(DruidSQLParser.ExpressionContext ctx);
	void exitExpression(DruidSQLParser.ExpressionContext ctx);

	void enterTimeFilter(DruidSQLParser.TimeFilterContext ctx);
	void exitTimeFilter(DruidSQLParser.TimeFilterContext ctx);

	void enterOrDimFilter(DruidSQLParser.OrDimFilterContext ctx);
	void exitOrDimFilter(DruidSQLParser.OrDimFilterContext ctx);

	void enterGroupby_stmt(DruidSQLParser.Groupby_stmtContext ctx);
	void exitGroupby_stmt(DruidSQLParser.Groupby_stmtContext ctx);

	void enterAggregate(DruidSQLParser.AggregateContext ctx);
	void exitAggregate(DruidSQLParser.AggregateContext ctx);

	void enterConstant(DruidSQLParser.ConstantContext ctx);
	void exitConstant(DruidSQLParser.ConstantContext ctx);

	void enterAndDimFilter(DruidSQLParser.AndDimFilterContext ctx);
	void exitAndDimFilter(DruidSQLParser.AndDimFilterContext ctx);

	void enterQuery(DruidSQLParser.QueryContext ctx);
	void exitQuery(DruidSQLParser.QueryContext ctx);

	void enterUnaryExpression(DruidSQLParser.UnaryExpressionContext ctx);
	void exitUnaryExpression(DruidSQLParser.UnaryExpressionContext ctx);

	void enterGranularityFn(DruidSQLParser.GranularityFnContext ctx);
	void exitGranularityFn(DruidSQLParser.GranularityFnContext ctx);

	void enterAdditiveExpression(DruidSQLParser.AdditiveExpressionContext ctx);
	void exitAdditiveExpression(DruidSQLParser.AdditiveExpressionContext ctx);

	void enterTimeAndDimFilter(DruidSQLParser.TimeAndDimFilterContext ctx);
	void exitTimeAndDimFilter(DruidSQLParser.TimeAndDimFilterContext ctx);

	void enterPrimaryExpression(DruidSQLParser.PrimaryExpressionContext ctx);
	void exitPrimaryExpression(DruidSQLParser.PrimaryExpressionContext ctx);

	void enterPrimaryDimFilter(DruidSQLParser.PrimaryDimFilterContext ctx);
	void exitPrimaryDimFilter(DruidSQLParser.PrimaryDimFilterContext ctx);

	void enterMultiplyExpression(DruidSQLParser.MultiplyExpressionContext ctx);
	void exitMultiplyExpression(DruidSQLParser.MultiplyExpressionContext ctx);

	void enterSelectorDimFilter(DruidSQLParser.SelectorDimFilterContext ctx);
	void exitSelectorDimFilter(DruidSQLParser.SelectorDimFilterContext ctx);

	void enterDimFilter(DruidSQLParser.DimFilterContext ctx);
	void exitDimFilter(DruidSQLParser.DimFilterContext ctx);

	void enterTimestamp(DruidSQLParser.TimestampContext ctx);
	void exitTimestamp(DruidSQLParser.TimestampContext ctx);

	void enterSelect_stmt(DruidSQLParser.Select_stmtContext ctx);
	void exitSelect_stmt(DruidSQLParser.Select_stmtContext ctx);

	void enterWhere_stmt(DruidSQLParser.Where_stmtContext ctx);
	void exitWhere_stmt(DruidSQLParser.Where_stmtContext ctx);

	void enterInListDimFilter(DruidSQLParser.InListDimFilterContext ctx);
	void exitInListDimFilter(DruidSQLParser.InListDimFilterContext ctx);

	void enterGroupByExpression(DruidSQLParser.GroupByExpressionContext ctx);
	void exitGroupByExpression(DruidSQLParser.GroupByExpressionContext ctx);

	void enterAliasedExpression(DruidSQLParser.AliasedExpressionContext ctx);
	void exitAliasedExpression(DruidSQLParser.AliasedExpressionContext ctx);

	void enterDatasource(DruidSQLParser.DatasourceContext ctx);
	void exitDatasource(DruidSQLParser.DatasourceContext ctx);
}
package com.xebia.fitnesse.meetup.slim.symbols;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import fitnesse.html.HtmlUtil;
import fitnesse.wikitext.parser.Matcher;
import fitnesse.wikitext.parser.PathsProvider;
import fitnesse.wikitext.parser.Symbol;
import fitnesse.wikitext.parser.SymbolType;
import fitnesse.wikitext.parser.Translation;
import fitnesse.wikitext.parser.Translator;
import org.apache.commons.lang.StringUtils;

public class InheritClasspathSymbolType extends SymbolType implements Translation, PathsProvider {

    public InheritClasspathSymbolType() {
        super(InheritClasspathSymbolType.class.getName());
        wikiMatcher(new Matcher().startLineOrCell().string("!inheritClasspath"));
    }

    @Override
    public String toTarget(Translator translator, Symbol symbol) {
        List<String> classpathElements = getClasspathElements();

        String classpathForRender = "";
        for (String element : classpathElements) {
            classpathForRender += HtmlUtil.metaText("classpath: " + element) + HtmlUtil.BR.html();

        }
        return classpathForRender;
    }

    @Override
    public Collection<String> providePaths(Translator translator, Symbol symbol) {
        return getClasspathElements();
    }

    private List<String> getClasspathElements() {
        List<String> classpathElements = Arrays.asList(System.getProperty("java.class.path").split(":"));
        Collection<String> filteredClasspathElements = Collections2.filter(classpathElements, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return !StringUtils.contains(input, " ");
            }
        });
        return Lists.newArrayList(filteredClasspathElements);
    }

}

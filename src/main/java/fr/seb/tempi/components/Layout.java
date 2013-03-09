package fr.seb.tempi.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;

import data.constants.Symbols;

/**
 * Layout component for pages of application tempi.
 */
@Import(stylesheet = {"context:css/bootstrap.min.css", "context:css/bootstrap-responsive.min.css"})
public class Layout
{
    /**
     * The page title, for the <title> element and the <h1> element.
     */
	@Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String pageTitle;

	@SuppressWarnings("unused")
	@Inject
    @Symbol(Symbols.PROJECT_NAME)
	@Property
    private String projectName;
    
    @Inject
    private ComponentResources resources;

    public String getClassForPageName()
    {
        return resources.getPageName().equalsIgnoreCase(pageTitle)
                ? "current_page_item"
                : null;
    }

    public String[] getPageNames()
    {
        return new String[]{"Index", "About", "Contact"};
    }
}

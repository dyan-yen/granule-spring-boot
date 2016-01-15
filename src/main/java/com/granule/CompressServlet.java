package com.granule;

import com.granule.cache.TagCacheFactory;
import com.granule.logging.Logger;
import com.granule.logging.LoggerFactory;
import com.granule.utils.PathUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/*
   Copy the original CompressServlet to put a @Component annotation.
 */
@Component
public class CompressServlet extends HttpServlet {
    private static final long serialVersionUID = -2526640346318371192L;
    private static String version = "unknown";
    private static final Logger logger = LoggerFactory.getLogger(CompressServlet.class);

    public CompressServlet() {
    }

    protected void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        this.process(var1, var2);
    }

    protected void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        this.process(var1, var2);
    }

    private void process(HttpServletRequest var1, HttpServletResponse var2) throws IOException, ServletException {
        String var3 = var1.getParameter("id");
        (new CompressorHandler()).handle(var1, var2, var3);
    }

    public void init() throws ServletException {
        java.util.logging.Logger var1 = java.util.logging.Logger.getLogger("com.google.javascript.jscomp");
        CompressServlet.CompilerLogFilter var2 = new CompressServlet.CompilerLogFilter();
        var1.setFilter(var2);
        var1 = java.util.logging.Logger.getLogger("com.google.javascript.jscomp.PhaseOptimizer");
        var1.setFilter(var2);

        try {
            TagCacheFactory.init(this.getServletConfig().getServletContext());
            this.loadVersion();
        } catch (IOException var4) {
            throw new ServletException(var4);
        }

        logger.info(MessageFormat.format("Granule {0} Started", new Object[]{version}));
    }

    private void loadVersion() {
        Properties var1 = new Properties();

        try {
            InputStream var2 = PathUtils.getResourceAsStream(this.getClass(), "/com/granule/config.properties");

            try {
                if(var2 == null) {
                    logger.warn("Can not find /com/granule/config.properties resource");
                } else {
                    var1.load(var2);
                }
            } finally {
                if(var2 != null) {
                    var2.close();
                }

            }

            if(var1.containsKey("version")) {
                version = var1.getProperty("version");
            }
        } catch (IOException var7) {
            logger.warn("Can not load config.properties", var7);
        }

    }

    public class CompilerLogFilter implements Filter {
        public CompilerLogFilter() {
        }

        public boolean isLoggable(LogRecord var1) {
            return !var1.getSourceClassName().startsWith("com.google.javascript.jscomp") || var1.getLevel().intValue() >= Level.WARNING.intValue();
        }
    }
}
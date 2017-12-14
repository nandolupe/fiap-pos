<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
    xmlns:lxslt="http://xml.apache.org/xslt"
    xmlns:redirect="http://xml.apache.org/xalan/redirect"
    extension-element-prefixes="redirect">

<!-- 
	Instruções para transformação e geração da documentação de
	violações de código Java.
	
	A alteração foi realizada através da versão disponibilizada
	pelo checkstyle (checkstyle_frames.xml). 
	
	Nesta versão foi incluída o tipo do erro (Info, Warning e Error) e
	o total para cada tipo de erro.
		
	@author Marcos Macedo
	
	@version 1.1
-->

    <xsl:output method="html" indent="yes" encoding="US-ASCII"/>
    <xsl:decimal-format decimal-separator="." grouping-separator="," />

    <xsl:param name="output.dir" select="'.'"/>

    <xsl:template match="checkstyle">
        <!-- create the index.html -->
        <redirect:write file="{$output.dir}/index.html">
            <xsl:call-template name="index.html"/>
        </redirect:write>

        <!-- create the stylesheet.css -->
        <redirect:write file="{$output.dir}/stylesheet.css">
            <xsl:call-template name="stylesheet.css"/>
        </redirect:write>

        <!-- create the overview-summary.html at the root -->
        <redirect:write file="{$output.dir}/overview-frame.html">
            <xsl:apply-templates select="." mode="overview"/>
        </redirect:write>

        <!-- create the all-classes.html at the root -->
        <redirect:write file="{$output.dir}/allclasses-frame.html">
            <xsl:apply-templates select="." mode="all.classes"/>
        </redirect:write>

        <!-- process all files -->
        <xsl:apply-templates select="file"/>
    </xsl:template>

    <xsl:template name="index.html">
        <html>
            <head>
                <title>CheckStyle Audit</title>
            </head>
            <frameset cols="20%,80%">
                <frame src="allclasses-frame.html" name="fileListFrame"/>
                <frame src="overview-frame.html" name="fileFrame"/>
            </frameset>
            <noframes>
                <h2>Frame Alert</h2>
                <p>
                    This document is designed to be viewed using the frames feature. If you see this message, you are using a non-frame-capable web client.
                </p>
            </noframes>
        </html>
    </xsl:template>

    <xsl:template name="pageHeader">
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tr>
                <td class="text-align:right"><h2>FIAP Audit</h2></td>
            </tr>
            <tr>
                <td class="text-align:right">Desenvolvimento</td>
            </tr>
        </table>
        <hr size="1"/>
    </xsl:template>

    <xsl:template match="checkstyle" mode="overview">
        <html>
            <head>
                <link rel="stylesheet" type="text/css" href="stylesheet.css"/>
            </head>
            <body>
                <!-- page header -->
                <xsl:call-template name="pageHeader"/>

                <!-- Summary part -->
                <xsl:apply-templates select="." mode="summary"/>
                <hr size="1" width="100%" align="left"/>

                <!-- File list part -->
                <xsl:apply-templates select="." mode="filelist"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template name="stylesheet.css">
        .bannercell {
        border: 0px;
        padding: 0px;
        }
        body {
        margin-left: 10;
        margin-right: 10;
        font:normal 80% arial,helvetica,sanserif;
        background-color:#FFFFFF;
        color:#000000;
        }
        .a td {
        background: #efefef;
        }
        .b td {
        background: #fff;
        }
        th, td {
        text-align: left;
        vertical-align: top;
        }
        th {
        font-weight:bold;
        background: #ccc;
        color: black;
        }
        table, th, td {
        font-size:100%;
        border: none
        }
        table.log tr td, tr th {

        }
        h2 {
        font-weight:bold;
        font-size:140%;
        margin-bottom: 5;
        }
        h3 {
        font-size:100%;
        font-weight:bold;
        background: #525D76;
        color: white;
        text-decoration: none;
        padding: 5px;
        margin-right: 2px;
        margin-left: 2px;
        margin-bottom: 0;
        }
    </xsl:template>

    <!--
    Replace DOS characters in a path.
    Replace '\' with '/', ':' with '_'.
    -->
    <xsl:template name="from-dos">
        <xsl:param name="path"/>
        <xsl:value-of select="translate($path, '\:', '/_')"/>
    </xsl:template>
    
    <!--
    Creates an all-classes.html file that contains a link to all files.
    -->
    <xsl:template match="checkstyle" mode="all.classes">
        <html>
            <head>
                <link rel="stylesheet" type="text/css" href="stylesheet.css"/>
            </head>
            <body>
                <h2>Files</h2>
                <p><a href="overview-frame.html" target="fileFrame">Summary</a></p>
                <p>
                    <table width="100%">
                        <!-- For each file create its part -->
                        <xsl:apply-templates select="file" mode="all.classes">
                            <xsl:sort select="@name"/>
                        </xsl:apply-templates>
                    </table>
                </p>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="checkstyle" mode="filelist">
        <h3>Files</h3>
        <table class="log" border="0" cellpadding="5" cellspacing="2" width="100%">
            <tr>
                <th>Name</th>
                <th>I</th>
                <th>W</th>
                <th>E</th>
            </tr>
            <xsl:apply-templates select="file" mode="filelist">
                <xsl:sort select="@name"/>
            </xsl:apply-templates>
        </table>
    </xsl:template>

    <xsl:template match="file" mode="filelist">
        <xsl:variable name="first">
            <xsl:call-template name="isfirst">
                <xsl:with-param name="name" select="@name"/>
            </xsl:call-template>
        </xsl:variable>
        <xsl:variable name="name" select="@name" />

        <xsl:if test="$first = 'true'">
            <xsl:variable name="new-name">
                <xsl:call-template name="from-dos">
                    <xsl:with-param name="path" select="@name"/>
                </xsl:call-template>
            </xsl:variable>
            <tr>
                <xsl:call-template name="alternated-row" />
                <td nowrap="nowrap">
                    <a>
                        <xsl:attribute name="href">
                            <xsl:text>files/</xsl:text><xsl:value-of select="$new-name"/><xsl:text>.html</xsl:text>
                        </xsl:attribute>
                        <xsl:value-of select="@name"/>
                    </a>
                </td>
                <td><xsl:value-of select="count(../file[@name = $name]/error[@severity='info'])"/></td>
                <td><xsl:value-of select="count(../file[@name = $name]/error[@severity='warning'])"/></td>
                <td><xsl:value-of select="count(../file[@name = $name]/error[@severity='error'])"/></td>
            </tr>
        </xsl:if>
    </xsl:template>

    <xsl:template match="file" mode="all.classes">
        <xsl:variable name="first">
            <xsl:call-template name="isfirst">
                <xsl:with-param name="name" select="@name"/>
            </xsl:call-template>
        </xsl:variable>

        <xsl:if test="$first = 'true'">
            <xsl:variable name="new-name">
                <xsl:call-template name="from-dos">
                    <xsl:with-param name="path" select="@name"/>
                </xsl:call-template>
            </xsl:variable>
            <tr>
                <td nowrap="nowrap">
                    <a target="fileFrame">
                        <xsl:attribute name="href">
                            <xsl:text>files/</xsl:text><xsl:value-of select="$new-name"/><xsl:text>.html</xsl:text>
                        </xsl:attribute>
                        <xsl:value-of select="@name"/>
                    </a>
                </td>
            </tr>
        </xsl:if>
    </xsl:template>

    <!--
    transform string like a/b/c to ../../../
    @param path the path to transform into a descending directory path
    -->
    <xsl:template name="path">
        <xsl:param name="path"/>
        <xsl:if test="contains($path,'/')">
            <xsl:text>../</xsl:text>
            <xsl:call-template name="path">
                <xsl:with-param name="path"><xsl:value-of select="substring-after($path,'/')"/></xsl:with-param>
            </xsl:call-template>
        </xsl:if>
        <xsl:if test="not(contains($path,'/')) and not($path = '')">
            <xsl:text>../</xsl:text>
        </xsl:if>
    </xsl:template>

    <xsl:template match="file">
        <xsl:variable name="first">
            <xsl:call-template name="isfirst">
                <xsl:with-param name="name" select="@name"/>
            </xsl:call-template>
        </xsl:variable>
        <xsl:variable name="name" select="@name" />

        <xsl:if test="$first = 'true'">
            <xsl:variable name="new-name">
                <xsl:call-template name="from-dos">
                    <xsl:with-param name="path" select="@name"/>
                </xsl:call-template>
            </xsl:variable>
            <redirect:write file="{$output.dir}/files/{$new-name}.html">
                <html>
                    <head>
                        <link rel="stylesheet" type="text/css">
                            <xsl:attribute name="href"><xsl:call-template name="path"><xsl:with-param name="path" select="$new-name"/></xsl:call-template><xsl:text>stylesheet.css</xsl:text></xsl:attribute>
                        </link>
                    </head>
                    <body>
                        <xsl:call-template name="pageHeader"/>
                        <h3>File <xsl:value-of select="@name"/></h3>
                        <table class="log" border="0" cellpadding="5" cellspacing="2" width="100%">
                            <tr>
                                <th width='80%'>Error Description</th>
                                <th>Line</th>
                                <th>Severity</th>
                            </tr>
                            <xsl:for-each select="../file[@name = $name]/error">
                                <tr>
                                    <xsl:call-template name="alternated-row"/>
                                    <td><xsl:value-of select="@message"/></td>
                                    <td><xsl:value-of select="@line"/></td>
                                    <td><xsl:value-of select="@severity"/></td>
                                </tr>
                            </xsl:for-each>
                        </table>
                    </body>
                </html>
            </redirect:write>
        </xsl:if>
    </xsl:template>

    <xsl:template match="checkstyle" mode="summary">
        <h3>Summary</h3>
        <xsl:variable name="fileCount" select="count(file)"/>
        <xsl:variable name="infoCount" select="count(file/error[@severity='info'])"/>
        <xsl:variable name="warningCount" select="count(file/error[@severity='warning'])"/>
        <xsl:variable name="errorCount" select="count(file/error[@severity='error'])"/>
        <xsl:variable name="totalCount" select="count(file/error)"/>
        
        <table class="log" border="0" cellpadding="5" cellspacing="2" width="100%">
            <tr>
                <th>Infos</th>
                <th>Warnings</th>
                <th>Errors</th>
                <th>Total</th>
            </tr>
            <tr>
                <xsl:call-template name="alternated-row"/>
                <td align="center"><xsl:value-of select="$infoCount"/></td>
                <td align="center"><xsl:value-of select="$warningCount"/></td>
                <td align="center"><xsl:value-of select="$errorCount"/></td>
                <td align="center"><xsl:value-of select="$totalCount"/></td>
            </tr>
        </table>
    </xsl:template>

    <xsl:template name="alternated-row">
        <xsl:attribute name="class">a</xsl:attribute>
    </xsl:template>

    <!-- determine if this is the first occurance of the given name in the input -->
    <xsl:template name="isfirst">
        <xsl:param name="name"/>
        <xsl:value-of select="count(preceding-sibling::file[@name=$name]) = 0"/>
    </xsl:template>

</xsl:stylesheet>


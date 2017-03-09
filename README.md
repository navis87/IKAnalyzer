# IKAnalyzer
IKAnalyzer 适配6.0以上solr ,支持IKAnalyzer和IKTokenizerFactory两种方式做分词

将src/main/resources下配置文件放到solr工程WEBINF/classes下即可

或者将pom.xml里面的src/main/resources的过滤注释掉就可以直接放在jar包中使用，不需要额外放配置文件

修改schema.xml,增加以下配置即可以使用分词搜索

<field name="content_test" type="textMaxWord" indexed="true" stored="true" multiValued="true"/>
	
	<field name="content_factpry" type="textComplex" indexed="true" stored="true"/>
	
	<fieldType name="textComplex" class="solr.TextField" positionIncrementGap="100">
      <analyzer type="index">
		<tokenizer class="org.wltea.analyzer.factory.IKTokenizerFactory" useSmart="true"/>
		 
       <filter class="solr.StopFilterFactory" ignoreCase="true" words="stopwords.txt" />
        <!-- in this example, we will only use synonyms at query time
        <filter class="solr.SynonymFilterFactory" synonyms="index_synonyms.txt" ignoreCase="true" expand="false"/>
        -->
        <filter class="solr.LowerCaseFilterFactory"/>
	  </analyzer>
	  <analyzer type="query">
		<tokenizer class="org.wltea.analyzer.factory.IKTokenizerFactory" useSmart="false"/>
		 
       <filter class="solr.StopFilterFactory" ignoreCase="true" words="stopwords.txt" />
        <filter class="solr.SynonymFilterFactory" synonyms="synonyms.txt" ignoreCase="true" expand="true"/>
        <filter class="solr.LowerCaseFilterFactory"/>
	  </analyzer>
    </fieldType>
	
	
	<fieldType name="textMaxWord" class="solr.TextField" >
      <analyzer class="org.wltea.analyzer.lucene.IKAnalyzer"/>
    </fieldType>
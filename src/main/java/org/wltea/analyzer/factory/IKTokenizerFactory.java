package org.wltea.analyzer.factory;

import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
import org.wltea.analyzer.lucene.IKTokenizer;

public class IKTokenizerFactory extends TokenizerFactory{

	/**是否使用智能查询*/
	private final boolean useSmart;
	
	
	public IKTokenizerFactory init(Map<String, String> args) {
		return new IKTokenizerFactory(args);
	}
	
	public IKTokenizerFactory(Map<String, String> args) {
		super(args);
		useSmart = getBoolean(args, "useSmart", false);
	}

	@Override
	public Tokenizer create(AttributeFactory factory) {
		return new IKTokenizer(factory, useSmart);
	}

}

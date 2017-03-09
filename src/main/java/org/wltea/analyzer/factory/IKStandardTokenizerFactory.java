package org.wltea.analyzer.factory;

import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

public class IKStandardTokenizerFactory extends TokenizerFactory {

	private final int maxTokenLength;
	
	public IKStandardTokenizerFactory init(Map<String, String> args) {
		
		return new IKStandardTokenizerFactory(args);
	}
	
	public IKStandardTokenizerFactory(Map<String, String> args) {
		super(args);
	    maxTokenLength = getInt(args, "maxTokenLength", StandardAnalyzer.DEFAULT_MAX_TOKEN_LENGTH);
	    if (!args.isEmpty()) {
	      throw new IllegalArgumentException("Unknown parameters: " + args);
	    }
	}

	@Override
	public Tokenizer create(AttributeFactory factory) {
		StandardTokenizer tokenizer = new StandardTokenizer(factory);
	    tokenizer.setMaxTokenLength(maxTokenLength);
	    return tokenizer;
	}

}

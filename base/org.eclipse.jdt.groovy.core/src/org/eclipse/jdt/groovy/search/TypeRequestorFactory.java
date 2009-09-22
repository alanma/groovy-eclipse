/*
 * Copyright 2003-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipse.jdt.groovy.search;

import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.internal.core.search.matching.FieldPattern;
import org.eclipse.jdt.internal.core.search.matching.MethodPattern;
import org.eclipse.jdt.internal.core.search.matching.PossibleMatch;
import org.eclipse.jdt.internal.core.search.matching.TypeReferencePattern;

/**
 * @author Andrew Eisenberg
 * @created Aug 31, 2009
 * 
 */
public class TypeRequestorFactory {

	/**
	 * @param possibleMatch
	 * @param pattern
	 * @param requestor
	 * @return
	 */
	public ITypeRequestor createRequestor(PossibleMatch possibleMatch, SearchPattern pattern, SearchRequestor requestor) {
		if (pattern instanceof TypeReferencePattern) {
			return new TypeReferenceSearchRequestor((TypeReferencePattern) pattern, requestor, possibleMatch.document
					.getParticipant());
		} else if (pattern instanceof FieldPattern) {
			return new FieldReferenceSearchRequestor((FieldPattern) pattern, requestor, possibleMatch.document.getParticipant());
		} else if (pattern instanceof MethodPattern) {
			return new MethodReferenceSearchRequestor((MethodPattern) pattern, requestor, possibleMatch.document.getParticipant());
		}

		return null;
	}

}
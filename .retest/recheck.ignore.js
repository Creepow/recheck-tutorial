// Here you can implement ignore rules for recheck in javascript.
// Please do not delete this file, even if it is empty.

// You can implement either of these two functions:
// shouldIgnoreElement(element)
// shouldIgnoreAttributeDifference(element, diff)

// You can find more details and example rules at: 
// https://retest.github.io/docs/recheck/how-ignore-works-in-recheck/

//var fontFamilies = [ [ "system-ui", "Arial" ], [ "-apple-system", "sans-serif" ] ];
//var baseUrl = /http[s]?:\/\/[\w.:\d\-]*/;
//
//function matches(element, diff) {
//    if (diff.key == "font-family") {
//        for (var i = 0; i < fontFamilies.length; i++) {
//            if (contains(fontFamilies[i], diff.expected)) {
//                return contains(fontFamilies[i], diff.actual);
//            }
//        }
//    }
//	if (diff.key == "opacity") {
//        return (Math.abs(diff.expected - diff.actual) <= 10);
//    }
//	if (diff.expected != null && diff.actual != null) {
//        cleanExpected = diff.expected.replace(baseUrl, '');
//        cleanActual = diff.actual.replace(baseUrl, '');
//        return cleanExpected === cleanActual;
//    }
//    return false;
//}

var fontFamilies = [ [ "system-ui", "Arial" ], [ "-apple-system", "sans-serif" ] ];

function matches(element, diff) {
    if (diff.key == "font-family") {
        for (var i = 0; i < fontFamilies.length; i++) {
            if (contains(fontFamilies[i], diff.expected)) {
                return contains(fontFamilies[i], diff.actual);
            }
        }
    }
    return false;
}
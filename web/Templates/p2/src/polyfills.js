"use strict";
require('es6-shim');
require('reflect-metadata');
require('zone.js/dist/zone');
if (process.env.ENV === 'production') {
}
else {
    // Development
    Error['stackTraceLimit'] = Infinity;
    require('zone.js/dist/long-stack-trace-zone');
}
//# sourceMappingURL=polyfills.js.map
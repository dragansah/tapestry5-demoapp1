// Copyright 2012 Dragan Sahpaski
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

Tapestry.Initializer.initSlider = function(spec) {
	var sliderId = spec.id;
	var zoneId = spec.zone;
	var updateURL = spec.updateURL;
	var _val = parseFloat(spec.value);
	var _step = parseFloat(spec.step);
	var _min = parseFloat(spec.min);
	var _max = parseFloat(spec.max);

	console.log(_val+" "+_min+" "+_max);
	jQuery( "#" + sliderId ).slider({
		min: _min,
		max: _max,
		step: _step,
		value: _val,
		slide: function( event, ui ) {
			Tapestry.findZoneManagerForZone(zoneId).updateFromURL(updateURL + "/" + ui.value);
		}
	});
};
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
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

package com.dragansah.demoapp.components;

import javax.inject.Inject;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library =
{ "jquery-1.7.1.min.js", "jquery-ui-1.8.17.custom.min.js", "slider.js" }, stylesheet = "ui-lightness/jquery-ui-1.8.17.custom.css")
public class Slider
{
	@Parameter(defaultPrefix = BindingConstants.LITERAL, required = true, allowNull = false)
	private String zone;

	@Parameter
	private Object context;

	@Parameter(required = true, allowNull = false)
	private String value;

	@Parameter(required = true, allowNull = false)
	private String min;

	@Parameter(required = true, allowNull = false)
	private String max;
	
	@Parameter(required = true, allowNull = false)
	private String step;

	@Environmental
	private JavaScriptSupport javaScriptSupport;

	@Inject
	private ComponentResources componentResources;

	void beginRender(MarkupWriter writer)
	{
		String id = javaScriptSupport.allocateClientId(componentResources);
		writer.element("div", "id", id);
		writer.end();
		Link link = componentResources.createEventLink("slide", context);
		javaScriptSupport.addInitializerCall("initSlider", new JSONObject("id", id, "zone", zone, "updateURL", link.toAbsoluteURI(),
				"value", value, "min", min, "max", max, "step", step));
	}
}

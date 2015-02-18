if (window.attachEvent) {
	window["event_load" + initialize] = initialize;
	window["load" + initialize] = function() {
		window["event_load" + initialize](window.event)
	};
	window.attachEvent("onload", window["load" + initialize])
} else {
	window.addEventListener("load", initialize, false)
}
var el_array = new Array();

function initialize() {
	var _1 = document.getElementById("main_body");
	if (_1) {
		removeClassName(_1, "no_guidelines");
		var _2 = getElementsByClassName(document, "*", "guidelines");
		if ((_1.offsetWidth <= 450) || (_2 == "")) {
			addClassName(_1, "no_guidelines", true)
		}
	}
	elements = getElementsByClassName(document, "*", "element");
	for (i = 0; i < elements.length; i++) {
		if (elements[i].type == "checkbox" || elements[i].type == "radio"
				|| elements[i].type == "file") {
			elements[i].onclick = function() {
				safari_reset();
				addClassName(this.parentNode.parentNode, "highlighted", true)
			};
			elements[i].onfocus = function() {
				safari_reset();
				addClassName(this.parentNode.parentNode, "highlighted", true)
			};
			el_array.splice(el_array.length, 0, elements[i])
		} else {
			elements[i].onfocus = function() {
				safari_reset();
				addClassName(this.parentNode.parentNode, "highlighted", true)
			};
			elements[i].onblur = function() {
				removeClassName(this.parentNode.parentNode, "highlighted")
			}
		}
	}
	var _3 = navigator.userAgent.toLowerCase();
	var _4 = document.getElementsByTagName("body");
	if (_3.indexOf("safari") + 1) {
		addClassName(_4[0], "safari", true)
	}
	if (_3.indexOf("firefox") + 1) {
		addClassName(_4[0], "firefox", true)
	}
}

function safari_reset() {
	for (var i = 0; i < el_array.length; i++) {
		removeClassName(el_array[i].parentNode.parentNode, "highlighted")
	}
}

function getElementsByClassName(_6, _7, _8) {
	var _9 = (_7 == "*" && _6.all) ? _6.all : _6.getElementsByTagName(_7);
	var _a = new Array();
	_8 = _8.replace(/\-/g, "\\-");
	var _b = new RegExp("(^|\\s)" + _8 + "(\\s|$)");
	var _c;
	for (var i = 0; i < _9.length; i++) {
		_c = _9[i];
		if (_b.test(_c.className)) {
			_a.push(_c)
		}
	}
	return (_a)
}

function removeClassName(_e, _f) {
	if (_e.className) {
		var _10 = _e.className.split(" ");
		var _11 = _f.toUpperCase();
		for (var i = 0; i < _10.length; i++) {
			if (_10[i].toUpperCase() == _11) {
				_10.splice(i, 1);
				i--
			}
		}
		_e.className = _10.join(" ")
	}
}

function addClassName(_13, _14, _15) {
	if (_13.className) {
		var _16 = _13.className.split(" ");
		if (_15) {
			var _17 = _14.toUpperCase();
			for (var i = 0; i < _16.length; i++) {
				if (_16[i].toUpperCase() == _17) {
					_16.splice(i, 1);
					i--
				}
			}
		}
		_16[_16.length] = _14;
		_13.className = _16.join(" ")
	} else {
		_13.className = _14
	}
}

function validateNameOnSubmit() {
	var returnValue = true;
	var itemToValidate = document.forms["addform"]["element_1"].value;
	if (itemToValidate.length < 5 || itemToValidate.length > 25) {
		returnValue = false;
	}
	if (itemToValidate.split(" ").length > 1) {
		returnValue = false;
	}
	return returnValue;
}
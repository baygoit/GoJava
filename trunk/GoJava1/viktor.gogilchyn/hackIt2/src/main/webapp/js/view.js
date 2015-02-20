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
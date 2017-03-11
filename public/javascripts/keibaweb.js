/**
 *
 */
$(function(){
	$(document).keydown(function(event){
		var keyCode = event.keyCode;
		var ctrlClick = event.ctrlKey;
		var altClick = event.altKey;
		var obj = event.target;

		if(keyCode == 8) {
			if((obj.tagName == "INPUT" && obj.type.toUpperCase() == "TEXT") || obj.tagName.toUpperCase() == "TEXTAREA") {
				if(!obj.readOnly && !obj.disabled) {
					return true;
				}
			}
			return false;
		}

		if(altClick && (keyCode == 37 || keyCode == 39)) {
			return false;
		}
	});
});

/*
 * 平均値を求める
 */
function average(data) {
	var sum = 0;

	for(var i = 0; i < data.length; i++) {
		sum = sum + parseInt(data[i]);
	}
	return (sum / data.length);
}

/*
 * 分散を求める
 */
function variance(data) {
	var ave = average(data);

	var varia = 0;
	for(var i = 0; i < data.length; i++){
		varia = varia + Math.pow(data[i] - ave, 2);
	}
	return (varia / data.length);
}

/*
 * 標準偏差を求める
 */
function stddev(data) {
	var varia = variance(data);

	return Math.sqrt(varia);
}

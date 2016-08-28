var Qs = function(arr, start, end) {
    if (start < end) {
        var index = partition(arr, start, end);
        Qs(arr, start, index - 1);
        Qs(arr, index + 1, end);
    }
}

function partition(arr, s, e) {
    var pivot = arr[e];
    var index = s;
    for (var i = s; i <= e; i++) {
        if (arr[i] <= pivot) {
            swap(arr, i, index);
            index++;
        }
    }
    return index;
}

function swap(arr, a, b) {
    var tmp = arr[b];
    arr[b] = arr[a];
    arr[a] = tmp;
}
var arr = [5,4,3,1,0,5,7,8,9,7,9];
Qs(arr, 0, arr.length - 1);
console.log(arr);
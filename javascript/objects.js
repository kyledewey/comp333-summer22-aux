Rectangle.prototype.getArea = function() {
    return this.width * this.height;
}
Rectangle.prototype.getWidth = function() {
    return this.width;
}
// Rectangle.prototype = {} // automatic
function Rectangle(inputWidth, inputHeight) {
    this.width = inputWidth;
    this.height = inputHeight;
    // this.__proto__ = Rectangle.prototype; // automatic
}


let rectanglePrototype = { 'getArea': function() {
    return this.width * this.height;
}};
function Rectangle(inputWidth, inputHeight) {
    this.width = inputWidth;
    this.height = inputHeight;
    this.__proto__ = rectanglePrototype;
}
// let r1 = new Rectangle(3, 4)
// let r2 = new Rectangle(5, 6)

const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
  let [l, r] = input[0].split(" ").map(Number);
  let l_count = 0;
  let r_count = 0;
  while (l > 1 && r > 1) {
    if (l > r) {
      l_count += parseInt(l / r);
      l %= r;
    } else {
      r_count += parseInt(r / l);
      r %= l;
    }
  }
  l_count += l - 1;
  r_count += r - 1;
  console.log(l_count, r_count);
}

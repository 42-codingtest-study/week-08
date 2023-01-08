const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
  const [N, S, D] = input[0].split(" ").map(Number);
  const tree = [0];
  for (let i = 1; i < N; i++) {
    tree.push(+input[i].split(" ")[1]);
  }
  console.log(tree);
}

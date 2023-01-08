const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
  let N = input[0] * 1;
  const tree = new Array(N + 1);
  for (let i = 0; i < N + 1; i++) {
    tree[i] = {};
  }
  for (let i = 1; i < N + 1; i++) {
    const [now, left, right] = input[i].split(" ").map(Number);
    tree[now].left = left;
    tree[now].right = right;
  }
  const visited = [...tree];
  let result = 0;
  console.log(visited);
  if (tree[1].left !== -1 && visited[1].left !== -2) {
    result += 1;
    visited[1].left = -2;
  }
}

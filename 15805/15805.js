// 맞는데 자꾸 틀리다해요 개짜증
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
  let N = input[0] * 1;
  const trace = input[1].split(" ").map(Number);
  const set1 = new Set([...trace]);
  let num = set1.size;
  const answer = new Array(num);
  answer[0] = -1;
  const visited = new Array(num).fill(false);
  visited[0] = true;
  for (let i = 1; i < N; i++) {
    if (!visited[trace[i]]) {
      answer[trace[i]] = trace[i - 1];
      visited[trace[i]] = true;
    }
  }
  let result = "";
  result += `${num}\n`;
  answer.map((e) => (result += `${e} `));
  console.log(result);
}

export async function fetchAccount() {
  const apiUrl = "https://api.examplebank.com/accounts/12345"; // replace with real endpoint
  const res = await fetch(apiUrl);
  if (!res.ok) {
    throw new Error(`Network response was not ok (${res.status})`);
  }
  return res.json();
}

// Minimal shared helpers for API calls, state, and toasts
window.App = (() => {
  const state = {
    get username() { return localStorage.getItem('username') || ''; },
    set username(v) { localStorage.setItem('username', v || ''); }
  };

  const api = async (path, opts = {}) => {
    const res = await fetch(path, {
      headers: { 'Content-Type': 'application/json', ...(opts.headers || {}) },
      ...opts
    });
    const text = await res.text();
    let json;
    try { json = JSON.parse(text); } catch { json = text; }
    return { ok: res.ok, status: res.status, data: json };
  };

  const toast = (msg, type = 'info') => {
    let el = document.querySelector('#toast');
    if (!el) {
      el = document.createElement('div');
      el.id = 'toast';
      el.className = 'fixed top-4 right-4 z-50';
      document.body.appendChild(el);
    }
    const item = document.createElement('div');
    const color = type === 'error' ? 'bg-red-600' : type === 'success' ? 'bg-emerald-600' : 'bg-slate-800';
    item.className = `${color} text-white px-4 py-2 rounded shadow mb-2 text-sm`;
    item.textContent = msg;
    el.appendChild(item);
    setTimeout(() => item.remove(), 3000);
  };

  return { state, api, toast };
})();



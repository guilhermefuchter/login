// Simula o login

document.querySelector("form").addEventListener("submit", function (event) { event.preventDefault(); const login = document.getElementById("login").value; const senha = document.getElementById("senha").value; if (login === "admin" && senha === "1234") { alert("Login realizado com sucesso!"); } else { alert("Login ou senha incorretos."); } });

// Referências para os elementos
const produtos = document.querySelectorAll('.add-to-cart');
const carrinhoItens = document.getElementById('carrinho-itens');
const totalInput = document.getElementById('total');

// Lista de itens do carrinho
let carrinho = [];

// Adicionar ao carrinho
produtos.forEach((produto) => {
  produto.addEventListener('click', () => {
    const item = produto.parentElement;
    const modelo = item.getAttribute('data-modelo');
    const tamanho = item.getAttribute('data-tamanho');
    const preco = parseFloat(item.getAttribute('data-preco'));
    const imagem = item.querySelector('img').src;

    // Adicionar item ao carrinho
    carrinho.push({ modelo, tamanho, preco, imagem });

    // Atualizar o carrinho na tela
    atualizarCarrinho();
  });
});

// Atualizar o carrinho na tela
function atualizarCarrinho() {
  // Limpar carrinho na tela
  carrinhoItens.innerHTML = '';

  // Total do carrinho
  let total = 0;

  // Adicionar itens ao carrinho na tela
  carrinho.forEach((item, index) => {
    total += item.preco;

    const divItem = document.createElement('div');
    divItem.classList.add('item');
    divItem.innerHTML = `
      <div class="foto"><img src="${item.imagem}" alt="${item.modelo}" style="width: 80px; height: 80px;"></div>
      <div class="item-info">
        <label>Modelo do Tênis:</label>
        <input type="text" value="${item.modelo}" readonly>
        <label>Tamanho do Tênis:</label>
        <input type="text" value="${item.tamanho}" readonly>
        <label>Preço do Tênis:</label>
        <input type="text" value="R$ ${item.preco.toFixed(2).replace('.', ',')}" readonly>
      </div>
      <button class="remove-btn" data-index="${index}">Remover do carrinho</button>
    `;
    carrinhoItens.appendChild(divItem);
  });

  // Atualizar total
  totalInput.value = `R$ ${total.toFixed(2).replace('.', ',')}`;

  // Adicionar evento de remoção
  document.querySelectorAll('.remove-btn').forEach((button) => {
    button.addEventListener('click', () => {
      const index = button.getAttribute('data-index');
      carrinho.splice(index, 1); // Remove o item do array
      atualizarCarrinho(); // Atualiza o carrinho na tela
    });
  });
}

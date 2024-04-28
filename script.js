// Define the ship class
class Ship {
    constructor(name, hp, damage, evasion, chanceToHit) {
      this.name = name;
      this.hp = hp;
      this.damage = damage;
      this.evasion = evasion;
      this.chanceToHit = chanceToHit;
    }
  
    attack(targetShip) {
      // Calculate hit chance
      const hitChance = Math.random() * 100;
      if (hitChance <= this.chanceToHit) {
        // Calculate damage based on evasion
        const damageDealt = Math.max(0, this.damage - targetShip.evasion);
        targetShip.takeDamage(damageDealt);
        console.log(`${this.name} hits ${targetShip.name} for ${damageDealt} damage!`);
      } else {
        console.log(`${this.name} misses ${targetShip.name}!`);
      }
    }
  
    takeDamage(amount) {
      this.hp -= amount;
      if (this.hp <= 0) {
        console.log(`${this.name} has been destroyed!`);
      }
    }
  }
  
  // Define the fleet class
  class Fleet {
    constructor(name, ships) {
      this.name = name;
      this.ships = ships;
    }
  
    attack(enemyFleet) {
      this.ships.forEach((ship) => {
        // Randomly select a ship from the enemy fleet to attack
        const targetShipIndex = Math.floor(Math.random() * enemyFleet.ships.length);
        const targetShip = enemyFleet.ships[targetShipIndex];
        ship.attack(targetShip);
      });
    }
  }
  
  // Function to display ships in a fleet
  function displayShips(fleet, containerId) {
    const container = document.getElementById(containerId);
    container.innerHTML = `<h2>${fleet.name}</h2>`;
    const shipList = document.createElement('div');
    shipList.className = 'ship-list';
  
    fleet.ships.forEach(ship => {
      const shipDiv = document.createElement('div');
      shipDiv.className = 'ship';
      shipDiv.textContent = `${ship.name} (HP: ${ship.hp}, Damage: ${ship.damage}, Evasion: ${ship.evasion}, Chance to Hit: ${ship.chanceToHit})`;
      shipList.appendChild(shipDiv);
    });
  
    container.appendChild(shipList);
  }
  
  // Example usage
  const playerFleet = new Fleet("Player Fleet", [
    new Ship("Player Ship 1", 100, 20, 10, 80),
    new Ship("Player Ship 2", 120, 15, 5, 70)
  ]);
  
  const enemyFleet = new Fleet("Enemy Fleet", [
    new Ship("Enemy Ship 1", 80, 25, 15, 75),
    new Ship("Enemy Ship 2", 100, 20, 10, 80)
  ]);
  
  // Display ships to the user
  displayShips(playerFleet, 'player-ships');
  displayShips(enemyFleet, 'enemy-ships');
  
  // Function to start the battle
  function startBattle() {
    console.log("Starting battle!");
    while (playerFleet.ships.length > 0 && enemyFleet.ships.length > 0) {
      console.log("Player's turn:");
      playerFleet.attack(enemyFleet);
  
      console.log("Enemy's turn:");
      enemyFleet.attack(playerFleet);
    }
  }
  
  // Attach click event listener to the Start Battle button
  const startBattleBtn = document.getElementById('start-battle-btn');
  startBattleBtn.addEventListener('click', startBattle);  
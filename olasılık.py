from itertools import product
import matplotlib.pyplot as plt

rp1 = int(input("Enter takım 1 tekrarı"))
rp2 = int(input("enter takım 2 tekrarı "))
t1p = int(input("enter t1  puanı"))
t2p = int(input("enter t2 puan"))


# Takım 2'nin 5 maçını da simüle eden versiyon
def simulate_full_5_matches(start_points_team1, start_points_team2):
    outcomes = [0, 1, 3]
    total_cases = 0
    champion_cases = 0

    for t1_results in product(outcomes, repeat=rp1):
        t1_total = start_points_team1 + sum(t1_results)
        for t2_results in product(outcomes, repeat=rp2):  # 5 maç
            t2_total = start_points_team2 + sum(t2_results)
            total_cases += 1
            if t2_total > t1_total:
                champion_cases += 1

    return champion_cases / total_cases * 100  # yüzde


# 75 puanla başlıyor ve 5 maç oynayacak
full_5match_prob = simulate_full_5_matches(t1p, t2p)

# Grafik hazırlığı
labels = ["Şampiyon", "Olamaz"]
sizes = [full_5match_prob, 100 - full_5match_prob]
colors = ['gold', 'lightgray']

fig, ax = plt.subplots()
ax.pie(sizes, labels=labels, autopct='%1.1f%%', startangle=90, colors=colors)
ax.axis('equal')  # Daire olarak göster
plt.title("Takım 2'nin Şampiyonluk İhtimali (5 Maç)")
plt.tight_layout()

var = full_5match_prob, fig
print("2. takımın şampiyon olma ihtimali= %", full_5match_prob)
print("2. takımın şampiyon olma ihtimali= %", full_5match_prob)
print("2. takımın şampiyon olma ihtimali= %", full_5match_prob)

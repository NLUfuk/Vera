from itertools import product
import matplotlib.pyplot as plt

# Kullanıcıdan veri al
rp1 = int(input("Takım 1'in kalan maç sayısı: "))
rp2 = int(input("Takım 2'nin kalan maç sayısı: "))
t1p = int(input("Takım 1'in mevcut puanı: "))
t2p = int(input("Takım 2'nin mevcut puanı: "))

# Simülasyon fonksiyonu
def simulate_full_matches(start_points_team1, start_points_team2):
    outcomes = [0, 1, 3]  # Maç sonucu: Mağlubiyet, Beraberlik, Galibiyet
    total_cases = 0
    champion_cases = 0
#get for all teams
    for t1_results in product(outcomes, repeat=rp1):
        t1_total = start_points_team1 + sum(t1_results)
        for t2_results in product(outcomes, repeat=rp2):
            t2_total = start_points_team2 + sum(t2_results)
            total_cases += 1
            if t2_total > t1_total:
                champion_cases += 1

    return champion_cases / total_cases * 100  # Şampiyonluk oranı (%)

# Hesapla
full_5match_prob = simulate_full_matches(t1p, t2p)

# Grafik için veri
sizes = [full_5match_prob, 100 - full_5match_prob]
labels = ['Takım 2 Şampiyon', 'Takım 1 Şampiyon veya Beraber']
colors = ['#ff9999', '#66b3ff']

# Grafik oluştur
fig, ax = plt.subplots()
ax.pie(sizes, labels=labels, autopct='%1.1f%%', startangle=90, colors=colors)
ax.axis('equal')
plt.title("Takım 2'nin Şampiyonluk İhtimali")
plt.tight_layout()

# Sonuç yazdır
print(f"\nTakım 2'nin şampiyon olma ihtimali: %{full_5match_prob:.2f}")
plt.show()

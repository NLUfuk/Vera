import json

TODO_FILE = "todo_list.json"

def load_tasks():
    try:
        with open(TODO_FILE, "r") as file:
            return json.load(file)
    except (FileNotFoundError, json.JSONDecodeError):
        return []

def save_tasks(tasks):
    with open(TODO_FILE, "w") as file:
        json.dump(tasks, file, indent=4)

def add_task(task):
    tasks = load_tasks()
    tasks.append({"task": task, "done": False})
    save_tasks(tasks)
    print(f"Eklendi: {task}")

def list_tasks():
    tasks = load_tasks()
    if not tasks:
        print("To-Do list boş.")
    for idx, task in enumerate(tasks, start=1):
        status = "[X]" if task["done"] else "[ ]"
        print(f"{idx}. {status} {task['task']}")

def mark_done(index):
    tasks = load_tasks()
    if 0 < index <= len(tasks):
        tasks[index - 1]["done"] = True
        save_tasks(tasks)
        print(f"Tamamlandı: {tasks[index - 1]['task']}")
    else:
        print("Geçersiz görev numarası.")

def delete_task(index):
    tasks = load_tasks()
    if 0 < index <= len(tasks):
        removed = tasks.pop(index - 1)
        save_tasks(tasks)
        print(f"Silindi: {removed['task']}")
    else:
        print("Geçersiz görev numarası.")

def main():
    while True:
        print("\nTo-Do List Uygulaması")
        print("1. Görevleri Listele")
        print("2. Görev Ekle")
        print("3. Görevi Tamamla")
        print("4. Görevi Sil")
        print("5. Çıkış")
        choice = input("Seçim yapın: ")
        
        if choice == "1":
            list_tasks()
        elif choice == "2":
            task = input("Eklemek istediğiniz görev: ")
            add_task(task)
        elif choice == "3":
            list_tasks()
            index = int(input("Tamamlanan görev numarası: "))
            mark_done(index)
        elif choice == "4":
            list_tasks()
            index = int(input("Silinecek görev numarası: "))
            delete_task(index)
        elif choice == "5":
            print("Çıkılıyor...")
            break
        else:
            print("Geçersiz seçim, tekrar deneyin.")

if __name__ == "__main__":
    main()
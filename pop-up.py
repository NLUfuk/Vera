import tkinter as tk
from tkinter import simpledialog, messagebox

def add_task():
    task = task_entry.get()
    if task:
        task_list.insert(tk.END, task)
        task_entry.delete(0, tk.END)
    else:
        messagebox.showwarning("Uyarı", "Lütfen bir görev girin!")

def remove_task():
    try:
        selected_task_index = task_list.curselection()[0]
        task_list.delete(selected_task_index)
    except IndexError:
        messagebox.showwarning("Uyarı", "Lütfen bir görev seçin!")

def retask():
    try:
        selected_task_index = task_list.curselection()[0]
        old_task = task_list.get(selected_task_index)
        new_task = simpledialog.askstring("Retasking", f"'{old_task}' görevini nasıl değiştirmek istersin?")
        if new_task:
            task_list.delete(selected_task_index)
            task_list.insert(selected_task_index, new_task)
    except IndexError:
        messagebox.showwarning("Uyarı", "Lütfen bir görev seçin!")

def show_info():
    messagebox.showinfo("Retasking Nedir?", "Retasking, bir görevi düzenleyerek farklı bir zaman dilimine veya farklı bir içeriğe çevirmektir.")

# Ana pencere
root = tk.Tk()
root.title("To-Do List")

# Görev giriş alanı
task_entry = tk.Entry(root, width=40)
task_entry.pack(pady=5)

# Görev listesi
task_list = tk.Listbox(root, width=50, height=10)
task_list.pack(pady=5)

# Butonlar
btn_frame = tk.Frame(root)
btn_frame.pack()

tk.Button(btn_frame, text="Görev ekle", command=add_task).grid(row=0, column=0, padx=5)
tk.Button(btn_frame, text="Görev Sil", command=remove_task).grid(row=0, column=1, padx=5)
tk.Button(btn_frame, text="Yeniden oluştur.", command=retask).grid(row=0, column=2, padx=5)


root.mainloop()

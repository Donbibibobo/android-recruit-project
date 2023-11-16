<h2>需求</h2>
<p>請使用 Kotlin 實作一個 app 首頁課程列表畫面，並寫文件或註解來解釋你的設計考量。除了指定需求外，你可以自由設計 model 和 UI 來提供更好的體驗。</p>

<h2>Library</h2>
<ul>
    <li>Jetpack - 基礎的 Activity、Fragment、DataBinding 使用。</li>
    <li>material - 使用 google 推薦的 material 元件。</li>
    <li>Moshi - 序列化與反序列化。</li>
    <li>Glide - 圖片加載。</li>
</ul>

<h2>數據層設計：</h2>
<p>採用官方推薦的 MVVM 架構和 Repository 模式，我設計了 <code>HaHowRepository</code> 作為數據加載的 Model 抽象層，也就是要求的「Data Loader」，並在 RemoteRepository 中模擬 API call 來得到 data.json 的內容。這種設計提高了代碼的可維護性和可測試性，同時允許靈活地處理不同數據源。</p>

<table>
  <tr>
    <td>
      <img width="955" alt="截圖 2023-11-16 下午5 10 16" src="https://github.com/Donbibibobo/android-recruit-project/assets/133195279/43efee11-ef7f-4023-9c11-60fe79d32f05">
      <p>簡略架構圖</p>
    </td>
    <td>
      <img width="705" alt="截圖 2023-11-16 下午5 42 21" src="https://github.com/Donbibibobo/android-recruit-project/assets/133195279/82ee6ad7-adc1-41a7-8363-926022671c20">
      <p>MVVM + Repository</p>
    </td>
  </tr>
</table>

<table>
  <tr>
    <td style="vertical-align: top; width: 50%;">
      <h2>UI 設計：</h2>
      <p>在 UI 設計上，我深入研究了「嘖嘖」、「flyingV」和「挖貝」...等平台的視覺元素，特別是它們對大塊版式的運用。於是我決定採用類似的樣板來提升用戶體驗，同時減少畫面上沒用到的「空白處」。查看資料整理：<a href="https://www.figma.com/file/bELOhcl9M4KmXJ0r5zNxgb/HaHow-recurit?type=design&node-id=0%3A1&mode=design&t=3mvO5LMmzUPRsa9I-1">Figma 設計連結</a>。</p>
      <p>另外，我特別把「status」拉出來作為一個獨立標籤，並將「倒數 n 天」直接放置於圖片上方。這種設計策略的目的是吸引用戶注意力，特別是對於那些「正在進行募資」的課程，從而增加用戶的參與度。</p>
    </td>
    <td>
      <img width="327" alt="截圖 2023-11-16 下午6 54 22" src="https://github.com/Donbibibobo/android-recruit-project/assets/133195279/303508f8-3e59-4db3-9c4c-0af0c8a07775">
    </td>
  </tr>
</table>

<h2>色調選擇：</h2>
<p>色調上，我選擇使用 HaHow 的品牌色調「綠色」以及「橘黃」和「淡藍色」。這些色調上屬於互補，能夠賦予畫面一種溫馨而活力的氛圍，還增強了用戶界面的吸引力和閱讀體驗。</p>


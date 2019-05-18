# 海外版TechCrunchの記事取得用API
## 環境構築手順 (Mac用)
1. プロジェクトをクローン  
`git clone https://github.com/kaju2759hiro/TcInformation`

2. Eclipse にインポート  
「ファイル」→「インポート」→「Gradle」→「既存のGradleプロジェクト」→「次へ」→プロジェクト・ルートディレクトリにクローンしたプロジェクトを指定→「完了」

3. 記事取得スクリプト実行のために Ruby がインストールされている事を確認  
`ruby -v`  
バージョンが表示されていれば OK

4. `tcinfo.properties` の CSV 書き出し用ディレクトリパスを適宜変更

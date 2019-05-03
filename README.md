# 海外版TechCrunchの記事取得用API
## 環境構築手順 (Mac用)
1. プロジェクトをクローン  
`git clone https://github.com/kaju2759hiro/TcInformation`

2. Eclipse にインポート  
「ファイル」→「インポート」→「Gradle」→「既存のGradleプロジェクト」→「次へ」→プロジェクト・ルートディレクトリにクローンしたプロジェクトを指定→「完了」

3. 記事取得スクリプト実行のために Ruby がインストールされている事を確認  
`ruby -v`  
バージョンが表示されていれば OK

4. 単体テストを実行

## サンプルのリクエスト
ターミナルから下記を実行  
`curl -v -X POST localhost:18080/tcinfo/getArticle -H "content-type:application/json" -d '{"lang":"ja","category":"apps"}'`
